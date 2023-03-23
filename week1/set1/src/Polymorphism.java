/* 4.	Write a single program to implement inheritance and polymorphism in java. */

public class Polymorphism {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle();
        rectangle.area(10, 5);

        Shape triangle = new Triangle();
        triangle.area(5, 4);

        Triangle triangle1 = new Triangle();
        triangle1.area(4);
    }
}

abstract class Shape{
    abstract void area(int a, int b);
}

class Rectangle extends Shape{

    @Override
    void area(int a, int b) {
        System.out.println("area of rectangle is " + a*b);
    }

}

class Triangle extends Shape{

    @Override
    void area(int a, int b) {
        System.out.println("area of triangle is " + 0.5 * a * b);
    }

    void area(int a) {
        System.out.println("area of equilateral triangle is " + (Math.sqrt(3)/4) * a  * a);
    }

}
