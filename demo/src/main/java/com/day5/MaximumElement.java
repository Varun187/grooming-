package com.day5;

import java.util.*;

public class MaximumElement {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(11, 24, 33, 41, 59, 100, 45, 96);
        // List<Integer> numbers1 = Arrays.asList();

        // Method 1
        Optional<Integer> maximum = numbers.stream().max(Integer::compare);
        if (maximum.isPresent())
            System.out.println(maximum.get());

        // Method 2
        int max = numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(); // NoSuchElementException

        System.out.println(max);
    }
}
