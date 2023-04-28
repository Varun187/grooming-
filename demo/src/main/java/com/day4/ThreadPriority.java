package com.day4;

// Write a program to set the Thread priority

public class ThreadPriority implements Runnable {

    @Override
    public void run() {
        // get the current thread priority
        int priority = Thread.currentThread().getPriority();
        System.out.println("Thread priority is " + priority);
    }

    public static void main(String[] args) {
        // create a new thread
        Thread thread = new Thread(new ThreadPriority());
        Thread thread1 = new Thread(new ThreadPriority());
        Thread thread2 = new Thread(new ThreadPriority());

        // set the thread priority to maximum
        thread.setPriority(Thread.MAX_PRIORITY);

        thread1.setPriority(Thread.MIN_PRIORITY);
        // thread.setPriority(Thread.NORM_PRIORITY);
        thread2.setPriority(8);

        // start the thread
        thread.start();
        thread1.start();
        thread2.start();
    }
}
