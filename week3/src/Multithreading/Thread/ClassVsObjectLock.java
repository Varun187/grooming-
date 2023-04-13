package Multithreading.Thread;

public class ClassVsObjectLock {
    public static void main(String[] args) {
        System.out.println("OBJECT LOCK");
        ObjectLock o1 = new ObjectLock();
        Thread t1 = new Thread(o1);
        Thread t2 = new Thread(o1);
        ObjectLock o2 = new ObjectLock();
        Thread t3 = new Thread(o2);
        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t1.start();
        t2.start();
        t3.start();


        ClassLock c1 = new ClassLock();
        Thread t4 = new Thread(c1);
        Thread t5 = new Thread(c1);
        ClassLock c2 = new ClassLock();
        Thread t6 = new Thread(c2);
        t4.setName("t4");
        t5.setName("t5");
        t6.setName("t6");
        t4.start();
        t5.start();
        t6.start();
    }
}

class ObjectLock implements Runnable {
    public void run() {
        Lock();
    }

    public void Lock() {
        System.out.println(
                Thread.currentThread().getName() + " tries to get lock");
        synchronized (this) {
            System.out.println(
                    "lock acquired by "
                            + Thread.currentThread().getName());
            System.out.println(
                    "lock to be released by "
                            + Thread.currentThread().getName()
                            + " end");
        }
    }
}

class ClassLock implements Runnable {
    public void run() {
        try {
            Lock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void Lock() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println(
                Thread.currentThread().getName() + " tries to get lock");
        synchronized (ClassLock.class) {
            System.out.println(
                    "lock acquired by "
                            + Thread.currentThread().getName());
            System.out.println(
                    "lock to be released by "
                            + Thread.currentThread().getName()
                            + " end");
        }
    }
}