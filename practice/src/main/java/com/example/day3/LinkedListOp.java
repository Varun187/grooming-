package com.example.day3;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListOp {
    public static void main(String[] args) {
        LinkedList<Integer> a = new LinkedList<Integer>();
        a.add(9);
        a.add(4);
        a.add(5);
        a.add(1);
        a.add(0);
        a.add(10);
        a.add(4);
        System.out.println(a);
        ListIterator<Integer> i=a.listIterator(a.size());
        while(i.hasPrevious()){
            System.out.print(i.previous()+" ");
        }
        System.out.println("\nFirst index of 4: "+a.indexOf(4)+"\nLast index of 4: "+a.lastIndexOf(4));
    }
}
