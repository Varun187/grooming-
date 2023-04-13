package Multithreading.Thread;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import Multithreading.Executors.Task;

public class CallableAndFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Task task = new Task("let's complete this");

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> result = executorService.submit(task);

        try {
            System.out.println(result.get());
        } catch (InterruptedException
                | ExecutionException e) {

            System.out.println(
                    "Error occurred while executing the submitted task");
            e.printStackTrace();
        }

        // Cleaning resource and shutting down JVM by
        // saving JVM state using shutdown() method
        executorService.shutdown();

        ExecutorService executorService1 = Executors.newFixedThreadPool(4);
        Callable<String> task1 = () -> {
            Thread.sleep(2000);
            return "Result of Task1";
        };

        Callable<String> task2 = () -> {
            Thread.sleep(1000);
            return "Result of Task2";
        };

        Callable<String> task3 = () -> {
            Thread.sleep(5000);
            return "Result of Task3";
        };

        // Returns the result of the fastest callable.
        String ans = executorService1.invokeAny(Arrays.asList(task1, task2, task3));

        System.out.println(ans);

        executorService1.shutdown();

    }

}
