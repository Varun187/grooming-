package Set;

import java.util.HashSet;
import java.util.Set;

import List.LinkedList.Vegetable;

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

        Set<Vegetable> vegetable1 = new HashSet<>();
        vegetable1.add(new Vegetable("Carrot", 40));
        vegetable1.add(new Vegetable("Tomato", 25));
        vegetable1.add(new Vegetable("Potato", 20));
        vegetable1.add(new Vegetable("Cabbage", 30));

        Set<Vegetable> vegetable2 = new HashSet<>();
        vegetable2.add(new Vegetable("Carrot", 40));
        vegetable2.add(new Vegetable("Tomato", 25));
        vegetable2.add(new Vegetable("Potato", 20));
        vegetable2.add(new Vegetable("Cabbage", 30));

        System.out.println("Is vegetable set1 and vegetable set2 are equal: " + vegetable1.equals(vegetable2));
        System.out.println();
    }
}
