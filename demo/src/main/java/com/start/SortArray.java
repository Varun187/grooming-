package com.start;

import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {

        int[] arr = { 3, 2, 1, 5, 4, 6, 8, 7 };
        int k = 3;
        Arrays.sort(arr);
        System.out.println("The sorted array is " + Arrays.toString(arr));
        System.out.println("The " + k + "th largest number in the array is: " + arr[arr.length - k]);
        System.out.println("The " + k + "th smallest number in the array is: " + arr[k - 1]);

    }
}
