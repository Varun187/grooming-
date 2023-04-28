package com.day4;

import java.util.concurrent.*;

public class FutureAndCalable {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        // Create a Callable that returns a result after 2 seconds
        Callable<String> callable = () -> {
            Thread.sleep(2000);
            return "Hello from Callable!";
        };

        // Submit the Callable to the executor and obtain a Future
        Future<String> future = executorService.submit(callable);

        // Wait for the result and retrieve it when available
        try {
            String result = future.get();
            System.out.println("Result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Shutdown the executor
        executorService.shutdown();
    }
}
