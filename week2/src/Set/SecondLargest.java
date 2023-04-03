package Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SecondLargest {
    public static void main(String[] args) {
        Set<Integer> set= new HashSet<>();
        Random random = new Random();
        for (int j = 0; j < 5; j++) {
            set.add(random.nextInt(10));  
        }
        System.out.println("set: " + set.toString());
        TreeSet<Integer> treeSet = new TreeSet<>(set);
        Iterator<Integer> iterator = treeSet.descendingIterator();
        iterator.next();
        int secondLargest = iterator.next(); 
        System.out.println("second largest " + secondLargest);
    }
}
