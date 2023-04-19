package streams;

import java.util.List;

//Given a list of integers, find out all the even numbers exist in the list using Stream functions?
public class EvenNumbers {
    public static void main(String[] args) {
        List<Integer> myList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        myList.stream()
                .filter(e -> e % 2 == 0)
                .forEach(System.out::println);
    }
}
