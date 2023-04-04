package Map;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ValueSort {
    public static void main(String[] args) {
        Map<String, Integer> studentMap = new HashMap<>();
        studentMap.put("karthik", 2);
        studentMap.put("shalini", 1);
        studentMap.put("abarna", 4);
        studentMap.put("sakthi", 3);

        Map<String, Integer> sortedMap = sortByValue(studentMap);
        printMap(sortedMap);
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

    public static void printMap(Map<String, Integer> map) {
        System.out.println("Sorted student map ");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Student name: " + entry.getKey() + " roll no: " + entry.getValue());
        }
    }
}
