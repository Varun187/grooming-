package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//How to find duplicate elements in a given integers list in java using Stream functions?
public class Duplicates {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(1, 4, 6, 9, 52, 45, 32, 4, 7, 9, 23, 72, 46, 52);

        // method1
        // System.out.println(
        // myList.stream()
        // .filter(e -> Collections.frequency(myList, e) > 1)
        // .collect(Collectors.toSet()));

        Predicate<Map.Entry<Integer, Long>> count = new CountPredicate(1);
        Function<Map.Entry<Integer, Long>, Integer> key = new GetKey();
        myList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(count)
                .map(key)
                .collect(Collectors.toSet())
                .forEach(new PrintConsumer<>());
    }
}

class PrintConsumer<T> implements Consumer<T> {

    @Override
    public void accept(T t) {
        System.out.println(t);
    }
}

class CountPredicate implements Predicate<Map.Entry<Integer, Long>> {
    private final long count;

    public CountPredicate(long count) {
        this.count = count;
    }

    public boolean test(Map.Entry<Integer, Long> entry) {
        return entry.getValue() > count;
    }
}

class GetKey implements Function<Map.Entry<Integer, Long>, Integer> {
    public Integer apply(Map.Entry<Integer, Long> entry) {
        return entry.getKey();
    }
}