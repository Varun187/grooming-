package com.day2.ques3;

public class Constructors {
    private String name;
    private int age;
    public String mail;

    // default constructor
    public Constructors() {
        mail = "Varun@gmail.com";
    }

    // Parameterized constructor
    public Constructors(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // copy constructor
    public Constructors(Constructors constructors) {
        this.name = constructors.name;
        this.age = constructors.age;
    }

    @Override
    public String toString() {
        return "Constructors [name=" + name + ", age=" + age + "]";
    }

    public static void main(String[] args) {
        Constructors constructors = new Constructors("Varun", 23);
        Constructors copyConstructors = new Constructors(constructors);
        System.out.println("Name: " + constructors.name);
        System.out.println("Age: " + constructors.age);

        System.out.println("Mail: " + constructors.mail); // default

        System.out.println(copyConstructors);
    }

}
