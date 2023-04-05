package Map;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import List.LinkedList.Vegetable;

//Program to sort a map based on keys
public class KeySort {
    public static void main(String[] args) {
        Map<String, Integer> studentMap = new HashMap<>();
        studentMap.put("shalini", 1);
        studentMap.put("karthik", 2);
        studentMap.put("sakthi", 3);
        studentMap.put("abarna", 4);

        Map<String, Integer> sortedMap = sortByKey(studentMap);
        printMap(sortedMap);

        Map<Vegetable, Integer> map = new HashMap<>();
        map.put(new Vegetable("Carrot", 40), 1);
        map.put(new Vegetable("Tomato", 25), 2);
        map.put(new Vegetable("Potato", 20), 3);

        Map<Vegetable, Integer> vegetableMap = sortByVegetablePrice(map);
        printVegetableMap(vegetableMap);

        // sortByKeyLambda(studentMap);

        Map<Vegetable, Integer> reversedVegMap = sortByVegetablePriceInReverseOrder(map);
        printVegetableMap(reversedVegMap);

    }

    private static Map<Vegetable, Integer> sortByVegetablePriceInReverseOrder(Map<Vegetable, Integer> map) {
        Map<Vegetable, Integer> sortedMap = new TreeMap<>(Collections.reverseOrder());
        sortedMap.putAll(map);

        return sortedMap;
    }

    private static Map<Vegetable, Integer> sortByVegetablePrice(Map<Vegetable, Integer> map) {
        Map<Vegetable, Integer> sortedMap = new TreeMap<>();
        sortedMap.putAll(map);

        return sortedMap;
    }

    public static void printVegetableMap(Map<Vegetable, Integer> map) {
        System.out.println("Sorted Vegetable map ");
        for (Map.Entry<Vegetable, Integer> entry : map.entrySet()) {
            System.out.println("Vegetable name: " + entry.getKey().getName() + " price per kg: " + entry.getKey().getPricePerKg());
        }
    }

    public static Map<String, Integer> sortByKey(Map<String, Integer> map) {
        Map<String, Integer> sortedMap = new TreeMap<>();
        sortedMap.putAll(map);

        return sortedMap;
    }

    public static Map<String, Integer> sortByKeyLambda(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> linkedList = new LinkedList<>(map.entrySet());

        Collections.sort(linkedList, (s1, s2) -> s1.getKey().toLowerCase().compareTo(s2.getKey().toLowerCase()));

        Map<String, Integer> studentMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : linkedList) {
            studentMap.put(entry.getKey(), entry.getValue());
        }

        return studentMap;
    }

    public static void printMap(Map<String, Integer> map) {
        System.out.println("Sorted student map ");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Student name: " + entry.getKey() + " roll no: " + entry.getValue());
        }
    }
}
