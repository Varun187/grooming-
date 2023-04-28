package com.day3;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Iterator;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        // Add elements to the LinkedList
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        // Display the LinkedList
        System.out.println("LinkedList: " + list);

        // Add an element at the beginning of the LinkedList
        list.addFirst(5);
        System.out.println("After adding an element at the beginning: " + list);

        // Add an element at the end of the LinkedList
        list.addLast(60);
        System.out.println("After adding an element at the end: " + list);

        // Remove the first element from the LinkedList
        list.removeFirst();
        System.out.println("After removing the first element: " + list);

        // Remove the last element from the LinkedList
        list.removeLast();
        System.out.println("After removing the last element: " + list);

        // Get the first occurance of the specified element
        System.out.println("First occureance of 20 is: " + list.indexOf(20));

        // Get the last occurrence of the specified element
        System.out.println("Last occureance of 40 is: " + list.lastIndexOf(40));

        // Display the LinkedList in reverse order
        // Descending Iterator
        System.out.println("Descending Iterator");
        Iterator<Integer> it = list.descendingIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // List Iterator
        System.out.println("List Iterator");
        ListIterator<Integer> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }

    }
}
