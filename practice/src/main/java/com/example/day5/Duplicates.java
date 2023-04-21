package com.example.day5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Duplicates {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 2, 6, 7, 3, 8, 9, 10, 5);
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
