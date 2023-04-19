package streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//How to find duplicate elements in a given integers list in java using Stream functions?
public class Duplicates {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(1, 4, 6, 9, 52, 45, 32, 4, 7, 9, 23, 72, 46, 52);

        System.out.println(
                myList.stream()
                        .filter(e -> Collections.frequency(myList, e) > 1)
                        .collect(Collectors.toSet()));

        myList.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
    }
}
