package Multithreading.Thread;

public class ThreadClass extends Thread {
    public void run() {
        System.out.print("Welcome !!!");
    }

    public static void main(String[] args) {
        ThreadClass thread1 = new ThreadClass(); // creating thread
        thread1.start(); // starting thread
    }
    
}
