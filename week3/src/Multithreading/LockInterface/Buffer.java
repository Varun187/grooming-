package Multithreading.LockInterface;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Buffer {
    private Queue<Long> list = new LinkedList<>();
    private final int bufferSize;

    private final Lock lock = new ReentrantLock();
    private final Condition bufferFull = lock.newCondition();
    private final Condition bufferEmpty = lock.newCondition();

    public Buffer(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    public void insert(long item, int prodId) {
        try {
            lock.lock();

            while (list.size() == this.bufferSize) {
                System.out.println("BUFFER FULL :: Insert waiting for consumption");
                bufferFull.await();
            }

            System.out.println("Producer " + prodId + " Inserted Item " + item);
            boolean isAdded = list.offer(item);
            if (isAdded) {
                System.out.println("ITEM COUNT :: " + list.size());
                bufferEmpty.signalAll();
            }

        } catch (InterruptedException e) {
            e.getMessage();
        } finally {
            lock.unlock();
        }
    }

    public void extract(int consId){
        try{
            lock.lock();

            while (list.isEmpty()) {
                System.out.println("BUFFER EMPTY :: Extract waiting for production");
                bufferEmpty.await();
            }
            
            System.out.println("Consumer " + consId + " Consumed " + list.peek());
            Long valueRemoved =  list.poll();
            if(valueRemoved != null){
                System.out.println("ITEM COUNT :: " + list.size());
                bufferFull.signalAll();
            }
        } catch (InterruptedException e) {
            e.getMessage();
        } finally {
            lock.unlock();
        }
    }
}
