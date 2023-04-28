package com.day4;

// Write a program to create Thread using Thread class

class Thread1 extends Thread {

    // code to be executed in this thread
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Executing thread 1");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Thread2 extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Executing thread 2");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadCreation {

    public static void main(String[] args) {
        // create a new thread
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        // Scheduler

        // start the thread
        thread1.start(); // runnable state

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
        thread1.start(); // IllegalThreadStateException, we can't start the thread again after its
                         // lifecycle.

    }
}
