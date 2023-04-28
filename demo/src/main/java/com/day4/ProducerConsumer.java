package com.day4;

import java.util.LinkedList;

class Producer implements Runnable {
    private LinkedList<Integer> buffer;
    private int maxSize;

    public Producer(LinkedList<Integer> buffer, int maxSize) {
        this.buffer = buffer;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        int value = 1;
        while (true) {
            try {
                produce(value);
                value++;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void produce(int value) throws InterruptedException {
        synchronized (buffer) {
            while (buffer.size() == maxSize) {
                System.out.println("Buffer is full. Producer is waiting...");
                buffer.wait();
            }

            buffer.add(value);
            System.out.println("Producer produced: " + value);
            buffer.notifyAll();
        }
    }
}

class Consumer implements Runnable {
    private LinkedList<Integer> buffer;

    public Consumer(LinkedList<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                consume();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void consume() throws InterruptedException {
        synchronized (buffer) {
            while (buffer.isEmpty()) {
                System.out.println("Buffer is empty. Consumer is waiting...");
                buffer.wait();
            }

            int value = buffer.removeFirst();
            System.out.println("Consumer consumed: " + value);
            buffer.notifyAll();
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        LinkedList<Integer> buffer = new LinkedList<>();
        int maxSize = 5;

        Producer producer = new Producer(buffer, maxSize);
        Consumer consumer = new Consumer(buffer);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}
