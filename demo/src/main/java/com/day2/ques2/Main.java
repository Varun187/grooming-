package com.day2.ques2;

public class Main {
    public static void main(String[] args) {
        ImmutableClass obj = new ImmutableClass(23, "Varun");
        System.out.println(obj);

        // obj.age=20; // it is immutable so throws error
    }
}
