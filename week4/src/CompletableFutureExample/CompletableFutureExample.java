package CompletableFutureExample;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture<String> future = new CompletableFuture<>();

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            future.complete("Future task completed!!");
        });

        thread.start();
        future.thenAccept(System.out::println);

        System.out.println("Main method finished execution");
    }
}
