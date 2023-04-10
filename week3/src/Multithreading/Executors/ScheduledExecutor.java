package Multithreading.Executors;

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutor {
    public static void main(String[] args) {
        System.out.println(
                "A count-down-clock program that counts from 10 to 0");

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(11);

        for (int i = 10; i >= 0; i--) {
            scheduler.schedule(new ScheduledTask(i), 10 - i,
                    TimeUnit.SECONDS);
        }

        scheduler.shutdown();
    }
}


class ScheduledTask implements Runnable {
    private int num;

    public ScheduledTask(int num) {
        this.num = num;
    }

    public void run() {
        System.out.println(
                "Number " + num + " Current time : "
                        + Calendar.getInstance().get(Calendar.SECOND));
    }
}