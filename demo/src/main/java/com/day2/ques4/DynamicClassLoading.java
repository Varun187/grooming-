package com.day2.ques4;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class DynamicClassLoading {
    public static void main(String[] args)
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException, ClassNotFoundException {

        Scanner sc = new Scanner(System.in);
        String className = sc.nextLine();

        Class<?> myClass = Class.forName("com.day2.ques4." + className);

        Object object = myClass.getDeclaredConstructor().newInstance();

        ((DynamicClass) object).show();

        sc.close();

    }
}
