package Multithreading.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        Runnable barrierAction = () -> System.out.println("Let's move to next place - Hills");

        CyclicBarrier barrier = new CyclicBarrier(3, barrierAction);

        Tourist ram = new Tourist(barrier, 1000);
        Tourist sita = new Tourist(barrier, 2000);
        Tourist krishna = new Tourist(barrier, 3000);

        new Thread(ram, "Ram").start();
        new Thread(sita, "Sita").start();
        new Thread(krishna, "Krishna").start();
    }
}

class Tourist implements Runnable {

    private final CyclicBarrier barrier;
    private final int delay;

    public Tourist(CyclicBarrier barrier, int delay) {
        this.barrier = barrier;
        this.delay = delay;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        System.out.println("Tourist  :-" + threadName.toUpperCase() + " started exploring the amusement park");
        try {
            Thread.sleep(delay);
            System.out.println(threadName + " - finished exploring waiting for others");
            this.barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}