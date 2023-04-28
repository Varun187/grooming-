package com.day4;

// How will you create a task & execute it

public class TaskCreation implements Runnable {

    @Override
    public void run() {
        // code to be executed by the task
        System.out.println("Task is executing...");
    }

    public static void main(String[] args) {
        // create and execute the task in a new thread
        Thread thread = new Thread(new TaskCreation());
        thread.start();

        // Using Lambda Expressions

        Runnable obj1 = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Executingg thread 1");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable obj2 = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Executingg thread 2");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();

    }
}
