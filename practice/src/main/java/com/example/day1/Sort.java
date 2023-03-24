package com.example.day1;

import java.util.Arrays;
import java.util.Scanner;

public class Sort {
    public static void main(String args[]){
        int size=Integer.parseInt(args[0]);
        int[] arr=new int[size];
        int i;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the numbers: ");
        for(i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println("Enter K");
        int k=sc.nextInt();
        System.out.println("Kth largest number: "+arr[arr.length-k]);
        System.out.println("Kth smallest number: "+arr[k-1]);
        sc.close();
    }
}
