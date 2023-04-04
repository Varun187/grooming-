package com.example.day3;

import java.util.HashSet;

public class HashSetOp {
    public static void main(String[] args) {
        HashSet<Integer> h1=new HashSet<Integer>();
        HashSet<Integer> h2=new HashSet<Integer>();
        h1.add(1);
        h1.add(3);
        h1.add(5);
        h1.add(7);
        h1.add(9);
        h1.add(11);
        h2.add(1);
        h2.add(3);
        h2.add(5);
        h2.add(7);
        h2.add(11);
        h2.add(9);
        System.out.println("Hashset h1 and h2 are equal: "+h1.equals(h2));

    }
}
