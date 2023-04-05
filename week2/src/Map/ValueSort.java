package Map;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import List.LinkedList.Vegetable;

public class ValueSort {
    public static void main(String[] args) {
        Map<String, Integer> studentMap = new HashMap<>();
        studentMap.put("karthik", 2);
        studentMap.put("shalini", 1);
        studentMap.put("abarna", 4);
        studentMap.put("sakthi", 3);

        Map<String, Integer> sortedMap = sortByValue(studentMap);
        printMap(sortedMap);

        Map<String, Integer> reverseSortedMap = sortByValueInDescOrder(studentMap);
        printMap(reverseSortedMap);

        Map<String, Vegetable> map = new HashMap<>();
        map.put("1", new Vegetable("Carrot", 40));
        map.put("2", new Vegetable("Tomato", 25));
        map.put("3", new Vegetable("Potato", 20));

        Map<String, Vegetable> vegetableMap = sortByVegPrice(map);
        printVegetableMap(vegetableMap);
    }

    public static Map<String, Vegetable> sortByVegPrice(Map<String, Vegetable> map) {
        List<Map.Entry<String, Vegetable>> linkedList = new LinkedList<>(map.entrySet());

        Collections.sort(linkedList, (s1, s2) -> s1.getValue().compareTo(s2.getValue()));

        Map<String, Vegetable> vegetableMap = new LinkedHashMap<>();
        for (Map.Entry<String, Vegetable> entry : linkedList) {
            vegetableMap.put(entry.getKey(), entry.getValue());
        }

        return vegetableMap;
    }

    public static void printVegetableMap(Map<String, Vegetable> map) {
        System.out.println("Sorted Vegetable map ");
        for (Map.Entry<String, Vegetable> entry : map.entrySet()) {
            System.out.println(
                    "Vegetable name: " + entry.getValue().getName() + " price per kg: " + entry.getValue().getPricePerKg());
        }
    }

    public static Map<String, Integer> sortByValue(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> linkedList = new LinkedList<>(map.entrySet());

        Collections.sort(linkedList, (s1, s2) -> s1.getValue().compareTo(s2.getValue()));

        Map<String, Integer> studentMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : linkedList) {
            studentMap.put(entry.getKey(), entry.getValue());
        }

        return studentMap;
    }

    public static Map<String, Integer> sortByValueInDescOrder(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> linkedList = new LinkedList<>(map.entrySet());

        Collections.sort(linkedList, (s1, s2) -> s2.getValue().compareTo(s1.getValue()));

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
