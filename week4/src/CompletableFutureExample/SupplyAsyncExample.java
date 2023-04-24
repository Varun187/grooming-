package CompletableFutureExample;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SupplyAsyncExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
               Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Result of the asynchronous computation";
        }, executor).thenApply(message -> {
            return message + " with callback executed";
        });

        future.thenAccept(System.out::println);
        System.out.println("Main thread executed");
    }
}
