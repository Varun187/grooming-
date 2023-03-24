package com.example.day1;

class Animal{  
    void eat(){
        System.out.println("Animal is eating");
    }  
}  
class Dog extends Animal{  
    void eat(){
        System.out.println("Dog is eating");
    }
    void play(String game){
        System.out.println("He is playing "+game);
    }
    void play(int days){
        System.out.println("He has been playing for "+days+" days");
    }
}
public class InheritAndPoly {
    public static void main(String args[]){  
        Dog d=new Dog();  
        d.eat();
        Animal a=new Dog();
        a.eat();
        // Dog an=new Animal();
        // Dog w=(Dog)an;
        // w.eat();
        //instanceOf
        d.play("Fetch");
        d.play(5);
    }
}
