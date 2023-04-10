package Multithreading.Executors;

// creating task using runnable
public class RunnableTask implements Runnable {
    private String message;

    public RunnableTask(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.message + " is sleeping...");
            Thread.sleep(3000);
            System.out.println(this.message + " is running...");
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception");
        }
    }

}
