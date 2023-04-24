package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

//How to check if list is empty in Java 8 using Optional, if not null iterate through the list and print the object?
public class EmptyList {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(1, 4, 7, 9, 52, 45, 32, 4, 7, 9, 23, 72, 46, 52);

        // Supplier<List<Integer>> supplier = () -> {
        // return new ArrayList<Integer>();
        // };

        Consumer<Integer> consumer = System.out::println;

        Optional.ofNullable(myList)
                .orElseThrow(() -> new InvalidInputException("Given list point to null")) // .orElseGet(supplier)
                .stream()
                .filter(Objects::nonNull)
                .forEach(consumer);

        Optional<List<Integer>> optionalList = Optional.ofNullable(myList);
        optionalList.ifPresent(System.out::println);
    }
}
