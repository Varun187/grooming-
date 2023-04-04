package com.example.day3;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListOp {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(9);
        a.add(4);
        a.add(5);
        a.add(1);
        a.add(0);
        a.add(10);
        System.out.println(a);
        a.add(2,11);
        System.out.println(a);
        a.remove(0);
        a.remove(Integer.valueOf(1));
        System.out.println(a);
        System.out.println(a.get(4));
        Collections.sort(a);
        System.out.println(a);
    }
}
