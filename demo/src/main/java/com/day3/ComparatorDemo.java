package com.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student [age=" + age + ", name=" + name + "]";
    }

}

public class ComparatorDemo {
    public static void main(String[] args) {

        // comparator using lambda functions
        Comparator<Student> comparator = (i, j) -> i.age > j.age ? 1 : -1;

        List<Student> student = new ArrayList<>();
        student.add(new Student(23, "Varun"));
        student.add(new Student(20, "Visva"));
        student.add(new Student(10, "Babu"));
        student.add(new Student(15, "Dhanusha"));
        student.add(new Student(30, "Vaishnavi"));

        Collections.sort(student, comparator);

        for (Student s : student) {
            System.out.println(s);
        }

    };

}
