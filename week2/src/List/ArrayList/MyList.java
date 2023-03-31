package List.ArrayList;

import java.util.ArrayList;
import java.util.List;

//Program to add, retrieve & remove element from ArrayList
public class MyList {
    public static void main(String args[]) {
        List<String> myList = new ArrayList<>(5);

        myList.add("Apple");
        myList.add("Orange");
        myList.add("banana");
        myList.add(1, "Mango");

        myList.set(2, "cherry");

        System.out.print("my list is: ");
        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + " ");
        }
        
        System.out.println();

        boolean isPresent = myList.contains("Orange");
        System.out.println("Is Orange present in the list? " + isPresent);

        myList.remove("banana"); // myList.remove(3);

        System.out.println("index of cherry: " + myList.indexOf("cherry"));

        ///myList.clear(); to remove all elements in list

        System.out.print("my list is: ");
        for (String str : myList)
            System.out.print(str + " ");
    }
}
