package com.day3;

import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(3);
        // set1.add(4);
        // System.out.println(set1);

        HashSet<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(2);
        set2.add(1);
        // System.out.println(set2);

        System.out.println(set1.equals(set2));

        // It uses a hashing algorithm to determine the position of each element in the
        // hash table

        HashSet<CustomObjects> cust = new HashSet<>();
        cust.add(new CustomObjects(1, "Varun"));
        cust.add(new CustomObjects(2, "Visva"));
        cust.add(new CustomObjects(3, "Babu"));
        cust.add(new CustomObjects(4, "Dhanusha"));

        HashSet<CustomObjects> cust1 = new HashSet<>();
        cust1.add(new CustomObjects(1, "Varun"));
        cust1.add(new CustomObjects(2, "Visva"));
        cust1.add(new CustomObjects(3, "Babu"));
        cust1.add(new CustomObjects(4, "Dhanusha"));
        cust1.add(new CustomObjects(1, "Varun"));

        System.out.println("Is both Custom objects are same " + cust.equals(cust1));

    }
}
