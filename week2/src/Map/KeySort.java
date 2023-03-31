package Map;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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

        // sortByKeyLambda(studentMap);

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
