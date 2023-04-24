package CompletableFutureExample;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunAsyncExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("Asyncronous computation completed");
        }, executor);
        System.out.println("Main thread executed");
    }
}
