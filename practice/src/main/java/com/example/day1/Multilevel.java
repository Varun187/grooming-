package com.example.day1;

class Animal{  
    void eat(){
        System.out.println("eating");
    }  
}  
class Dog extends Animal{  
    void bark(){
        System.out.println("barking");
    }
}
class Labrador extends Dog{
    void play(){
        System.out.println("play fetch");
    }
}
public class Multilevel{  
    public static void main(String args[]){  
        Labrador l=new Labrador();  
        l.eat();  
        l.bark(); 
        l.play(); 
    }
}  