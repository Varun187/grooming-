package List.LinkedList;

import java.util.LinkedList;

public class MyLinkedList {
    public static void main(String[] args) {
        LinkedList<String> myList = new LinkedList<>();
        myList.add("B");
        myList.add("C");
        myList.add("D");
        
        System.out.println(myList.toString());

        myList.addFirst("A");
        myList.addLast("E");
        myList.remove("C");

        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + " ");
        }

        Object[] listToArray = myList.toArray();
        System.out.print("After converted LinkedList to Array: ");
        for (Object element : listToArray)
            System.out.print(element + " ");

        System.out.println("First element in list" + myList.peek());
    }
}
