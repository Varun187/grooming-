package Multithreading.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        int count = 5;
        CountDownLatch latch = new CountDownLatch(count - 2);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int name = 1; name <= count; name++) {
            executorService.execute(new Worker(latch, name, 1000 * name));
        }
        latch.await();
        System.out.println(Thread.currentThread().getName() +
                " has finished");
        executorService.shutdown();
    }
}

class Worker implements Runnable {
    private final CountDownLatch latch;
    private final int name;
    private final int delay;

    Worker(CountDownLatch latch, int name, int delay) {
        this.latch = latch;
        this.name = name;
        this.delay = delay;
    }

    public void run() {
        show();
        latch.countDown();
        System.out.println("Thread " + name + " completed.");
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void show() {
        System.out.println("Thread " + name + " working ...");
    }
}
