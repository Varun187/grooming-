package Multithreading.Thread;

public class ThreadPriority extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Priority of thread is: " + Thread.currentThread().getPriority());
        }
    }

    public static void main(String[] args) {
        ThreadPriority th1 = new ThreadPriority();
        th1.setPriority(Thread.MAX_PRIORITY);
        ThreadPriority th2 = new ThreadPriority();
        th2.setPriority(Thread.NORM_PRIORITY);
        th2.start();
        th1.start();
    }
}
