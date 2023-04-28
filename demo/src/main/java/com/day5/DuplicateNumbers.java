package com.day5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// How to find duplicate elements in a given integers list in java using Stream functions

public class DuplicateNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(11, 22, 32, 41, 54, 21, 6, 79, 3, 80, 9999, 10123, 5);
        List<Integer> duplicateNumbers = numbers.stream()
                .collect(Collectors.groupingBy(n -> n))
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size() > 1)
                .map(e -> e.getKey())
                .collect(Collectors.toList());

        System.out.println("Duplicate Numbers are : " + duplicateNumbers);
    }

}
