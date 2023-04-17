package Multithreading.ConcurrentCollections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Sakthi", "Kumar", "Ram");
        // List<String> copyOnWriteList = new ArrayList<>(list); - fail fast
        CopyOnWriteArrayList<String> copyOnWriteList = new CopyOnWriteArrayList<String>(list);

        System.out.println("Without modification = " + copyOnWriteList);

        // iterator
        Iterator<String> iterator1 = copyOnWriteList.iterator();

        copyOnWriteList.add("Suresh");

        System.out.println("After modification = " + copyOnWriteList);

        //iterator 2
        Iterator<String> iterator2 = copyOnWriteList.iterator();

        System.out.println("Element from first Iterator:");
        iterator1.forEachRemaining(System.out::println);
        System.out.println("Element from Second Iterator:");
        iterator2.forEachRemaining(System.out::println);
    }
}
