package List.LinkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

// Java program to iterate a linked list in reverse order.
public class ReverseOrder {
    public static void main(String[] args) {
        LinkedList<String> myList = new LinkedList<>();
        myList.add("A");
        myList.add("B");
        myList.add("C");
        myList.add("D");

        //method1
        Iterator<String> decendingIterator = myList.descendingIterator();

        System.out.println("Method 1");
        System.out.print("Linked list iterated in reverse order: ");
        while(decendingIterator.hasNext()){
            System.out.print(decendingIterator.next() + " ");
        }

        //method2
        ListIterator<String> listIterator = myList.listIterator(myList.size());

        System.out.println("\nMethod 2");
        System.out.print("Linked list iterated in reverse order: ");
        while(listIterator.hasPrevious()){
            System.out.print(listIterator.previous() + " ");
        }

    }
}
