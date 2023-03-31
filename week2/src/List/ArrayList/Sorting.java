package List.ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Java program to sort a given array list
public class Sorting {
    public static void main(String[] args) {
        int[] arr = {15,14,6,9,22,4,5,2,1};
        Integer[] integers = new Integer[arr.length];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = Integer.valueOf(arr[i]);
        }
        List<Integer> myList = new ArrayList<>(List.of(integers));
        Collections.sort(myList);

        System.out.println("Array after sorting in ascending order: " + myList);

        Collections.sort(myList, Collections.reverseOrder());
        System.out.println("Array after sorting in decending order: " + myList);

    }
}
