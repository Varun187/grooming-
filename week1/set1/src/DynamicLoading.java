import java.util.Scanner;

public class DynamicLoading {
    public static void main(String[] args) throws ClassNotFoundException{
        String string = new String();// static loading

        // dynamic loading
        Class obj = Class.forName("java.lang.String");
        System.out.print("obj is an object of class: " + obj.toString());
    }
}

interface Shape {
    abstract void area(int a, int b);
}

class Rectangle extends Shape {

    @Override
    void area(int a, int b) {
        System.out.println("area of rectangle is " + a * b);
    }

}

class Triangle extends Shape {

    @Override
    void area(int a, int b) {
        System.out.println("area of triangle is " + 0.5 * a * b);
    }

    void area(int a) {
        System.out.println("area of equilateral triangle is " + (Math.sqrt(3) / 4) * a * a);
    }

}