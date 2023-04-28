package com.start;

import java.util.Scanner;

public class add {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num1 = sc.nextDouble();
        double num2 = sc.nextDouble();
        double sum = num1 + num2;
        System.out.println("The sum of " + num1 + " and " + num2 + " is " + sum +
                ".");

        System.out.println(Integer.parseInt(args[0]) + Integer.parseInt(args[1]));

    }
}
