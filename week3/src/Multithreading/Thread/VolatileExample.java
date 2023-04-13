package Multithreading.Thread;

public class VolatileExample {
    private static volatile int counter = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            int localCounter = counter;

            while (localCounter < 5) {
                if (localCounter != counter) {
                    System.out.println("[T1] local counter is changed to " + (localCounter+1));
                    localCounter = counter;
                }
            }
        });

        Thread t2 = new Thread(() -> {
            int localCounter = counter;

            while (localCounter < 5) {
                System.out.println("[T2] incremented counter to " + (localCounter + 1));
                counter = ++localCounter;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        t1.start();
        t2.start();

    }
}