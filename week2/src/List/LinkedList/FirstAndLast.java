// Write a Java program to get the first and last occurrence of the specified elements in a linked list

package List.LinkedList;

import java.util.LinkedList;
import java.util.Scanner;

//Java program to get the first and last occurrence of the specified elements in a linked list
public class FirstAndLast {
    public static void main(String[] args) {
        LinkedList<String> myLinkedList = new LinkedList<>();
        myLinkedList.add("apple");
        myLinkedList.add("orange");
        myLinkedList.add("banana");
        myLinkedList.add("mango");
        myLinkedList.add("orange");
        myLinkedList.add("grapes");

        System.out.println("First element of a linked list: " + myLinkedList.getFirst());
        System.out.println("Last element of a linked list: " + myLinkedList.getLast());

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a fruit name: ");
        String fruit = scanner.next();

        System.out.println(
                "First occurence of " + fruit + " in the linked list: " + myLinkedList.indexOf(fruit.toLowerCase()));

        System.out.println(
                "Last occurence of " + fruit + " in the linked list: " + myLinkedList.lastIndexOf(fruit.toLowerCase()));

        scanner.close();
    }
}
