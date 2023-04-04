package com.example.day2;

import java.util.Scanner;
import java.lang.reflect.InvocationTargetException;

public class LoadClass {
    public static void main(String[] args)
        throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        String className = sc.nextLine();
        Class<?> myClass = Class.forName("com.example.day2." + className);
        Object object = myClass.getDeclaredConstructor().newInstance();
        ((Player)object).display();
        sc.close();
    }
    
}
