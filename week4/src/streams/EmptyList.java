package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//How to check if list is empty in Java 8 using Optional, if not null iterate through the list and print the object?
public class EmptyList {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(1, 4, 7, 9, 52, 45, 32, 4, 7, 9, 23, 72, 46, 52);

        Optional<List<Integer>> optionalList = Optional.ofNullable(myList);
        optionalList.ifPresent(System.out::println);
    }
}
