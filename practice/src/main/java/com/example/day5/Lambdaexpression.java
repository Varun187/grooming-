package com.example.day5;

//Normal, Single abstract method or functional, Marker
interface Dog{
    String bark();
}
public class Lambdaexpression {
    public static void main(String[] args) {
        // Dog d=new Dog(){
        //     public String bark(){
        //         System.out.println("Barking...");
        //     }
        // };
        // System.out.println(d.bark());
        Dog d=()->{
            return "Barking";
        };
        System.out.println(d.bark());
    }
}
