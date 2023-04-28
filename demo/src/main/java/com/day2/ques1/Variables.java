package com.day2.ques1;

public class Variables {

    static int count; // static variables

    public Variables() {
        count++;
    }

    static {
        count = 10; // static blocks
        // They are executed only once, when the class is loaded into the JVM.
    }

    public static int add(int num1, int num2) { // static methods
        return num1 + num2;
    }

    public static void main(String[] args) {

        // Variables variables = new Variables();
        System.out.println(Variables.count);

        System.out.println(Variables.add(10, 5));
    }

}
