package com.day5;

// import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalList {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("Varun", "Sudharshan", "Visvadhi", "Sreeram");
        // List<String> myList = new ArrayList<>();

        Optional<List<String>> optionalList = Optional.of(myList);

        // Method 1
        optionalList.ifPresent(list -> {
            for (String str : list) {
                System.out.println(str);
            }
        });
        if (myList.isEmpty()) {
            System.out.println("List is empty!");
        }

        // Method 2
        optionalList.ifPresentOrElse(list -> {
            // Iterate through the list and print the objects
            for (String str : list) {
                System.out.println(str);
            }
        },
                () -> System.out.println("List is empty!"));
    }
}
