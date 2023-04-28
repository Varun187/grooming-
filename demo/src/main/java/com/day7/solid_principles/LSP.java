package com.day7.solid_principles;

//Liskov Substitution Principle

class Vehicle {
    protected int speed;

    public Vehicle(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void accelerate() {
        speed += 10;
    }

    public void brake() {
        speed -= 10;
    }
}

class Car extends Vehicle {
    public Car(int speed) {
        super(speed);
    }

    @Override
    public void accelerate() {
        speed += 20;
    }

    @Override
    public void brake() {
        speed -= 20;
    }
}

class Bicycle extends Vehicle {
    public Bicycle(int speed) {
        super(speed);
    }

    @Override
    public void accelerate() {
        speed += 5;
    }

    @Override
    public void brake() {
        speed -= 5;
    }
}

public class LSP {
    static void testDrive(Vehicle vehicle) {
        vehicle.accelerate();
        vehicle.brake();
        vehicle.accelerate();
        vehicle.brake();
        System.out.println("Speed: " + vehicle.getSpeed());
    }

    public static void main(String[] args) {
        Car car = new Car(100);
        Bicycle bicycle = new Bicycle(30);

        testDrive(car);
        testDrive(bicycle);
    }
}

// The Car and Bicycle classes both adhere to the Liskov Substitution Principle
// because they behave consistently with the base Vehicle class. They both have
// the same public interface and the same pre- and post-conditions as the
// Vehicle class.
