package com.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student1 implements Comparable<Student1> {
    int age;
    String name;

    public Student1(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String toString() {
        return "Student [age=" + age + ", name=" + name + "]";
    }

    public int compareTo(Student1 o) {
        return this.age > o.age ? 1 : -1;
    }

}

public class ComparableDemo {
    public static void main(String[] args) {

        List<Student1> student = new ArrayList<>();
        student.add(new Student1(23, "Varun"));
        student.add(new Student1(20, "Visva"));
        student.add(new Student1(10, "Babu"));
        student.add(new Student1(15, "Dhanusha"));
        student.add(new Student1(30, "Vaishnavi"));

        Collections.sort(student);

        for (Student1 s : student) {
            System.out.println(s);
        }

    };

}
