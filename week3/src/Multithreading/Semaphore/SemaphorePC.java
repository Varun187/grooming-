package Multithreading.Semaphore;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

class Q {
    Queue<Integer> q = new LinkedList<>();

    static Semaphore semCon = new Semaphore(0);
    static Semaphore semProd = new Semaphore(1);

    void get() {
        try {
            // Before consumer can consume an item,
            // it must acquire a permit from semCon
            semCon.acquire();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }

        // consumer consuming an item
        System.out.println("Consumer consumed item : " + q.poll());

        // After consumer consumes the item,
        // it releases semProd to notify producer
        semProd.release();
    }

    void put(int item) {
        try {
            // Before producer can produce an item,
            // it must acquire a permit from semProd
            semProd.acquire();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }

        // producer producing an item
        q.offer(item);

        System.out.println("Producer produced item : " + item);

        // After producer produces the item,
        // it releases semCon to notify consumer
        semCon.release();
    }
}

// Producer class
class Producer implements Runnable {
    Q q;

    Producer(Q q) {
        this.q = q;
    }

    public void run() {
        for (int i = 0; i < 5; i++)
            q.put(i);
    }
}

// Consumer class
class Consumer implements Runnable {
    Q q;

    Consumer(Q q) {
        this.q = q;
    }

    public void run() {
        for (int i = 0; i < 5; i++)
            q.get();
    }
}

// Driver class
public class SemaphorePC {
    public static void main(String args[]) {
        Q q = new Q();

        Consumer consumer = new Consumer(q);
        Producer producer = new Producer(q);

        Thread c1 = new Thread(consumer);
        Thread p1 = new Thread(producer);

        c1.start();
        p1.start();
    }
}
