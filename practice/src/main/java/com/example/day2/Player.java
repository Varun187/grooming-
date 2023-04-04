package com.example.day2;

public class Player {
    String name;
    int age;
    public Player() {
        System.out.println("Default constructor is called");
    }
    public Player(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Parameterized constructor to set both name and age is called");
    }
    public Player(int age) {
        this.age = age;
        System.out.println("Parameterized constructor to age is called");
    }
    public Player(String name) {
        this.name = name;
        System.out.println("Parameterized constructor to set name is called");
    }
    public Player(Player p1){
        this.name=p1.name;
        this.age=p1.age;
        System.out.println("Copy constructor is called");
    }
    void display(){
        System.out.println(name+" "+age);
    }
    public static void main(String[] args) {
        Player p1=new Player("Jemima",22);
        p1.display();
        Player p2=new Player("Lanning");
        p2.display();
        Player p3=new Player(24);
        p3.display();
        Player p4=new Player();
        p4.display();
        Player p5=new Player(p1);
        p5.display();
    }
}
