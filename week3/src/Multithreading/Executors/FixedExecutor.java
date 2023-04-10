package Multithreading.Executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FixedExecutor {
    public static void main(String[] args) {

        // method 1
        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        executorService1.execute(new RunnableTask("First task"));
        executorService1.execute(new RunnableTask("Second task"));
        executorService1.execute(new RunnableTask("Third task"));

        executorService1.shutdown();

        // method 2
        Task task = new Task("let's complete this");

        ExecutorService executorService = Executors.newFixedThreadPool(4);
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
    }
}
