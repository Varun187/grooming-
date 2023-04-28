package com.day2.ques1;

// Static nested classes 

public class OuterClass {
    private static String name = "Varun";

    public static class InnerClass {
        public void printName() {
            System.out.println("Name = " + name);
        }
    }

    public static void main(String[] args) {
        OuterClass.InnerClass inner = new OuterClass.InnerClass();
        inner.printName();
    }
}
