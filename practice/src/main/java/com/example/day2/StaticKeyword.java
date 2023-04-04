package com.example.day2;

public class StaticKeyword {
    static{
        count=1;
        System.out.println("static block");
    }
    static int count;
    static void displayCount(){
        System.out.println(count++);
    }
    public static void main(String[] args){
        System.out.println("main function");
        displayCount();
        displayCount();
    }
}
