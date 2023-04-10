package Multithreading.Executors;

import java.util.concurrent.Callable;

// creating task using callable
public class Task implements Callable<String> {
    private String message;

    public Task(String message) {
        this.message = message;
    }

    public String call() throws Exception {
        return "Hello from task " + message + "!";
    }

}
