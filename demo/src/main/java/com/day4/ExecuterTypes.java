package com.day4;

import java.util.concurrent.*;

public class ExecuterTypes {

    public static void main(String[] args) {
        // Example of using a fixed thread pool executor
        Executor executor1 = Executors.newFixedThreadPool(2);
        for (int i = 1; i <= 5; i++) {
            executor1.execute(() -> {
                System.out.println("Task executed by FixedThreadPool: " + Thread.currentThread().getName());
            });
        }

        // Example of using a cached thread pool executor
        Executor executor2 = Executors.newCachedThreadPool();
        for (int i = 1; i <= 5; i++) {
            executor2.execute(() -> {
                System.out.println("Task executed by CachedThreadPool: " + Thread.currentThread().getName());
            });
        }

        // Example of using a single thread executor
        Executor executor3 = Executors.newSingleThreadExecutor();
        for (int i = 1; i <= 5; i++) {
            executor3.execute(() -> {
                System.out.println("Task executed by SingleThreadExecutor: " + Thread.currentThread().getName());
            });
        }

        // Example of using a scheduled executor
        ScheduledExecutorService executor4 = Executors.newScheduledThreadPool(1);
        executor4.schedule(() -> {
            System.out.println("Task executed by ScheduledThreadPool: " + Thread.currentThread().getName());
        }, 2, TimeUnit.SECONDS);

        // Shutdown the executors
        ((ExecutorService) executor1).shutdown();
        ((ExecutorService) executor2).shutdown();
        ((ExecutorService) executor3).shutdown();
        executor4.shutdown(); // since it is already implements ScheduledExecutorService
    }
}
