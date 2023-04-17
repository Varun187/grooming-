package Multithreading.ConcurrentCollections;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapConcurrent implements Runnable {

    static ConcurrentHashMap<Integer, String> m = new ConcurrentHashMap<Integer, String>();

    @Override
    public void run() {

        try {
            Thread.sleep(2000);
            // Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        System.out.println("Child Thread updating Map");
        m.put(3, "C");
    }

    public static void main(String arg[])
            throws InterruptedException {

        m.put(1, "A");
        m.put(2, "B");

        Thread child = new Thread(new HashMapConcurrent());
        child.start();

        Set<Integer> s1 = m.keySet();

        Iterator<Integer> itr = s1.iterator();

        while (itr.hasNext()) {
            Integer I1 = itr.next();
            System.out.println(
                    "Main Thread Iterating Map and Current Entry is:"
                            + I1 + "..." + m.get(I1));
            Thread.sleep(3000);
            // Thread.sleep(1000);
        }

        System.out.println(m);
    }
}

class Example{
    public static void main(String[] args) {
        
        Map<Integer, String> map = new ConcurrentHashMap<>(Map.of(
            1, "INITIAL_VALUE",
            2, "INITIAL_VALUE",
            3, "INITIAL_VALUE"
            ));
            
    // Slowly write to key [1] in the map using `compute`.
    new Thread(()->
    {
        // 
         {
            map.compute(1, (key, value) -> {
                for (int i = 0; i < 3; i++) {
                    System.out.println("[1] computing...");
                    sleep(2000);
                }
                return "COMPUTE";
            });
            System.out.println("[1] updated from compute");
        }
    }).start();
    
    // Write to each key in the map in a loop.
    for(
        int key:map.keySet())
        {
            new Thread(() -> {
                // while (true) 
                {

                    sleep(3000);
                    map.put(key, "THREAD");
                    System.out.println("[" + key + "] updated from thread");
                }
            }).start();
        }
    }
    
    // Just added to contain the try/catch when sleeping.
    private static void sleep(int time) {
        try {
    Thread.sleep(time);
  } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
