package com.example.day3;

import java.util.HashSet;
import java.util.Iterator;

class Dog{
    String name;
    int age;
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void display(){
        System.out.println("Name: "+this.name+" Age: "+this.age);
    }
}
public class CustomHashSet {
    public static void main(String[] args) {
        HashSet<Dog> h=new HashSet<Dog>();
        h.add(new Dog("Rocky",5));
        h.add(new Dog("Ellie",6));
        h.add(new Dog("Zazu",11));
        h.add(new Dog("Walle",2));
        h.add(new Dog("Max",7));
        Iterator<Dog> i=h.iterator();
        while(i.hasNext()){
            i.next().display();
        }
        System.out.println("Inserting a duplicate and displaying: ");
        h.add(new Dog("Rocky",5));
        for(Dog d:h){
            d.display();
        }
        System.out.println("Size: "+h.size());
    }
}
