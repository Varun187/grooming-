package Multithreading.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new RunnableTask("First task"));
        executorService.execute(new RunnableTask("Second task"));
        executorService.execute(new RunnableTask("Third task"));

        executorService.shutdown();
    }
}
