package com.day6;

import java.util.concurrent.CompletableFuture;

// Write a program to run a simple asynchronous stage using CompletableFuture.Run a task asynchronously and return the result ?

public class CompletableFutureDemo {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> { // over rides the get method()
            try {
                Thread.sleep(1000);
                System.out.println("Thread execution - " + Thread.currentThread().getName()); // Global Pool
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Completable Future";
        });

        // Attach a callback to the CompletableFuture that will print the result
        // whenit's ready
        future.thenAccept(result -> System.out.println(result));
        future.join();
    }
}
