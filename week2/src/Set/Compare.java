package Set;

import java.util.HashSet;
import java.util.Set;

//Java program to compare two hash set
public class Compare {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        set1.add("apple");
        set1.add("orange");
        set1.add("banana");
        set1.add("mango");
        set1.add("orange");
        set1.add("grapes");

        Set<String> set2 = new HashSet<>();
        set2.add("orange");
        set2.add("grapes");
        set2.add("apple");
        set2.add("mango");
        set2.add("banana");

        System.out.println("Is set1 and set2 are equal: " + set1.equals(set2));
    }
}
