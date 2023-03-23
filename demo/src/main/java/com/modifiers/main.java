package com.modifiers;

public class main {
    public static void main(String args[]) {

        hello obj = new hello();
        obj.setA(20);
        obj.setName("Dhanusha");

        System.out.println(obj.getName());
        System.out.println(obj.getA());
        obj.show();
        System.out.println(obj);

    }
}
