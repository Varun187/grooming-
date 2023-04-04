package com.example.day2;

public class Strings {
    public static void main(String[] args){
        StringBuffer s1=new StringBuffer("Java");
        s1.append("Hello");
        s1.insert(9,"Java");
        s1.replace(0,4,"Hiii");
        System.out.println(s1.toString());
        StringBuilder s2=new StringBuilder("Java");
        s2.delete(0,4);
        s2.append("Java");
        s2.reverse();
        System.out.println(s2.toString());
    }
}
