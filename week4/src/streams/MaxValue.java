package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//Given a list of integers, find the maximum value element present in it using Stream functions?
public class MaxValue {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(1, 4, 7, 9, 52, 45, 32, 4, 7, 9, 23, 72, 46, 52);

        Integer max = myList.stream()
                .max(Integer::compare)
                .orElseThrow(() -> new InvalidInputException("invalid input"));
        System.out.println(max);
                

        myList.stream()
                .reduce((x, y) -> x > y ? x : y)
                .ifPresent(System.out::println);

        myList.stream()
                .max(Comparator.comparing(Integer::valueOf))
                .ifPresent(System.out::println);

        myList.stream()
                .max(Comparator.naturalOrder())
                .ifPresent(System.out::println);
    }
}
