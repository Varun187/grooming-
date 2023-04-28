package com.day4;

// Write a program to interrupt a Thread

public class ThreadInterrupt implements Runnable {

    @Override
    public void run() {
        try {
            // wait for 5 seconds
            Thread.sleep(5000);
            System.out.println("Thread is running...");
        } catch (InterruptedException e) {
            // handle the interrupt
            System.out.println("Thread was interrupted!");
        }
    }

    public static void main(String[] args) {
        // create a new thread
        Thread thread = new Thread(new ThreadInterrupt());

        // start the thread
        thread.start();

        // interrupt the thread after 2 seconds
        try {
            Thread.sleep(7000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
