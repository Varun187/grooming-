package com.example.day4;

import java.util.LinkedList;

class Implementation{
    LinkedList<Integer> buffer=new LinkedList<>();
    int max_size;
    public Implementation(int max_size) {
        this.max_size = max_size;
    }
    void produce() throws InterruptedException{
        int value=1;
        while(true){
        synchronized(this){
            while(buffer.size()==max_size){
                System.out.println("Buffer is full");
                wait();
            }
            System.out.println("Producer produced: "+value);
            buffer.add(value);
            value++;
            notify();
            Thread.sleep(1000);
        }
    }
    }
    void consume() throws InterruptedException{
        synchronized(this){
        while(true){
            while(buffer.size()==0){
                System.out.println("Buffer is empty");
                wait();
            }
            int value=buffer.removeFirst();
            System.out.println("Consumer consumed: "+value);
            notify();
            Thread.sleep(1000);
        }
    }
    }
}
public class ProducerConsumer{
    public static void main(String[] args) throws InterruptedException{
        final Implementation i=new Implementation(5);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    i.produce();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    i.consume();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        // t1.join();
        // t2.join();
    }
}
