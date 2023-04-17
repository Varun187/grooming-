package Multithreading.LockInterface;


public class LockProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Started");
        Buffer buffer = new Buffer(2);

        Consumer c1 = new Consumer(buffer, 1);
        Consumer c2 = new Consumer(buffer, 2);
        Producer p1 = new Producer(buffer, 1);
        Producer p2 = new Producer(buffer, 2);

        c1.start();
        c2.start();
        p1.start();
        p2.start();

        c1.join();
        c2.join();
        p1.join();
        p2.join();
    }
}

class Consumer extends Thread {
    private final Buffer buffer;
    private final int id;
    private static int count = 3; 

    public Consumer(Buffer buffer, int id) {
        this.buffer = buffer;
        this.id = id;
    }

    @Override
    public void run() {
        while (count >= 0) {
            try {
                this.buffer.extract(this.id);
                count--;
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread {
    private final Buffer buffer;
    private final int id;
    private static int count = 3;

    public Producer(Buffer buffer, int id) {
        this.buffer = buffer;
        this.id = id;
    }

    @Override
    public void run() {
        while (count >= 0) {
            try {
                this.buffer.insert((long) (Math.random() * 1000), this.id);
                count--;
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
