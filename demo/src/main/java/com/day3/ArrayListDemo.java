package com.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public class ArrayListDemo {
    public static void main(String[] args) {
        // Create a new ArrayList
        ArrayList<String> list = new ArrayList<>();

        // Add elements to the ArrayList
        list.add("Varun");
        list.add("Dhanusha");
        list.add("Visvadhi");

        // Retrieve an element from the ArrayList
        String firstElement = list.get(0);
        System.out.println("First element: " + firstElement);

        // Remove an element from the ArrayList
        list.remove(1);
        System.out.println("After removing an element: " + list);

        // Add another element to the ArrayList
        list.add("Sakthikumar");

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Babu");
        list1.add("Vasanth");
        list.addAll(list1);

        System.out.println("After adding another list: " + list);

        // Sorting ArrayList
        Collections.sort(list);

        // Printing sorted list
        System.out.println("Sorted List " + list);

        // clear list
        list1.clear();

        // calling custom objects
        CustomObjects customObjects = new CustomObjects(1, "Varun");
        CustomObjects customObjects1 = new CustomObjects(2, "Dhanu");
        CustomObjects customObjects2 = new CustomObjects(3, "Visva");

        ArrayList<CustomObjects> list3 = new ArrayList<>();
        list3.add(customObjects);
        list3.add(customObjects1);
        list3.add(customObjects2);

        // List Iterator
        System.out.println("List Iterator");
        ListIterator<CustomObjects> listIterator = list3.listIterator(list3.size());
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }

    }
}
