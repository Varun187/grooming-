package com.day7.solid_principles;

//Interface Segregation Principle 

interface IWorkable {
    void work();
}

interface IEatable {
    void eat();
}

// Worker class that implements both IWorkable and IEatable
class Worker implements IWorkable, IEatable {
    public void work() {
        System.out.println("Worker is working");
    }

    public void eat() {
        System.out.println("Worker is eating");
    }
}

// Robot class that implements only IWorkable
class Robot implements IWorkable {
    public void work() {
        System.out.println("Robot is working");
    }
}

// Manager class that manages workers
class Manager {
    public void manageWork(IWorkable worker) {
        worker.work();
    }

    public void manageEat(IEatable eater) {
        eater.eat();
    }
}

public class ISP {
    public static void main(String[] args) {
        Manager manager = new Manager();

        Worker worker = new Worker();
        Robot robot = new Robot();

        manager.manageWork(worker);
        manager.manageEat(worker);

        manager.manageWork(robot);
    }
}
