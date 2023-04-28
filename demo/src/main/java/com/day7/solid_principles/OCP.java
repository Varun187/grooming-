package com.day7.solid_principles;
//Open-Closed Principle 

//Shape class is open for extension, as new shapes can be added without modifying the existing code.
abstract class Shape {
    public abstract void draw();
}

// classes are closed for modification, as they inherit from the Shape class and
// implement their own draw() method.

class Rectangle extends Shape {
    public void draw() {
        System.out.println("Rectangle");
    }
}

class Circle extends Shape {
    public void draw() {
        System.out.println("Circle");
    }
}

class Triangle extends Shape {
    public void draw() {
        System.out.println("Triangle");
    }
}

public class OCP {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle();
        Shape circle = new Circle();
        Shape triangle = new Triangle();

        rectangle.draw();
        circle.draw();
        triangle.draw();

    }
}
