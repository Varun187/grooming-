package com.day3;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortedMapDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Varun");
        map.put(3, "Visva");
        map.put(4, "Dhanusha");
        map.put(2, "SakthiKumar");

        Map<Integer, String> sortedMap = new TreeMap<>(map);

        for (Map.Entry<Integer, String> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
