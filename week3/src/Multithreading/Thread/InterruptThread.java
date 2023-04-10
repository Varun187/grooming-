package Multithreading.Thread;

public class InterruptThread {
    public static void main(String args[]) {

        ScenarioOne t1 = new ScenarioOne();
        t1.start();
        t1.interrupt();

        ScenarioTwo t2 = new ScenarioTwo();
        t2.start();
        t2.interrupt();

        ScenarioThree t3 = new ScenarioThree();
        t3.start();
        try {
            t3.interrupt();
        } catch (Exception e) {
            System.out.println("Exception handled");
        }

        System.out.println("Main thread execution finished");

    }
}

class ScenarioOne extends Thread {
    public void run() {
        System.out.println("Scenario 1 - " + "IsInterrupted: " + isInterrupted());

    }
}

class ScenarioTwo extends Thread {
    public void run() {
        try {
            Thread.sleep(2000);  
        } catch (InterruptedException e) {
            System.out.println("Scenario 2 -" + "IsInterrupted: " + isInterrupted());
            System.out.println("Interrupted exception occurs in Scenario 2");
        }
    }
}

class ScenarioThree extends Thread {
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Scenario 3 -" + "IsInterrupted: " + isInterrupted());
            throw new RuntimeException("Thread " +
                    "interrupted in scenario 3");
        }
    }
}