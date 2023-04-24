package streams;

import java.util.List;
import java.util.function.Predicate;

class PredicateEven implements Predicate<Integer> {

    @Override
    public boolean test(Integer integer) {
        return integer % 2 == 0;
    }
}
//Given a list of integers, find out all the even numbers exist in the list using Stream functions?
public class EvenNumbers {
    public static void main(String[] args) {
        List<Integer> myList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        PredicateEven predicateEven = new PredicateEven();

        // myList.stream()
        //         .filter(e -> e % 2 == 0)
        //         .forEach(System.out::println);

        myList.stream()
                .filter(predicateEven)
                .forEach(new PrintConsumer<>());
    }
}
