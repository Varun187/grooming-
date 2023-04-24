package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TraderTransactionEg {
        public static void main(String[] args) {
                Trader raoul = new Trader("Raoul", "Cambridge");
                Trader mario = new Trader("Mario", "Milan");
                Trader alan = new Trader("Alan", "Cambridge");
                Trader brian = new Trader("Brian", "Cambridge");

                List<Transaction> transactions = Arrays.asList(
                                new Transaction(brian, 2011, 300),
                                new Transaction(raoul, 2012, 1000),
                                new Transaction(raoul, 2011, 400),
                                new Transaction(mario, 2012, 710),
                                new Transaction(mario, 2012, 700),
                                new Transaction(alan, 2012, 950));

                /*
                 * 
                 * 1. Find all transactions in the year 2011 and sort them by value (small to
                 * high).
                 * 2. What are all the unique cities where the traders work?
                 * 3. Find all traders from Cambridge and sort them by name.
                 * 4. Return a string of all traders’ names sorted alphabetically.
                 * 5. Are any traders based in Milan?
                 * 6. Print all transactions’ values from the traders living in Cambridge.
                 * 7. What’s the highest value of all the transactions?
                 * 8. Find the transaction with the smallest value
                 * 
                 */

                // ques1
                System.out.println(
                                "\n Qn1: Find all transactions in the year 2011 and sort them by value (small to high)");
                // Predicate<Transaction> transactionOf2011 = transaction ->
                // transaction.getYear() == 2011;
                Collector<Object, ?, List<Object>> listCollector = Collectors.toList();
                transactions.stream()
                                .filter(new TransactionOf2011())
                                .sorted(new ValueComparator())
                                .collect(listCollector)
                                .forEach(new ForEachConsumer<>());

                // ques2
                System.out.println("\n Qn2: What are all the unique cities where the traders work?");

                transactions.stream()
                                .map(new TraderCity())
                                .distinct()
                                .collect(Collectors.toList())
                                .forEach(new ForEachConsumer<>());

                // ques3
                System.out.println("\n Qn3: Find all traders from Cambridge and sort them by name");

                transactions.stream()
                                .map(new TraderFromTransaction())
                                .filter(new CityPredicate("Cambridge"))
                                .distinct()
                                .sorted(Comparator.comparing(new TraderName()))
                                .collect(Collectors.toList())
                                .forEach(new ForEachConsumer<>());

                // ques4
                System.out.println("\n Q4: Return a string of all trader's names sorted alphabetically");

                String traderNames = transactions.stream()
                                .map(new TraderNameFromTransaction())
                                .distinct()
                                .sorted()
                                .reduce("", (n1, n2) -> n1 + " - " + n2);

                System.out.println(traderNames);

                // ques5
                System.out.println("\n Q5: Are any traders based in Milan?");

                boolean malenBased = transactions.stream()
                                .anyMatch(transaction -> {
                                        Trader trader = new TraderFromTransaction().apply(transaction);
                                        Boolean isMatchFound = new CityPredicate("Milan").test(trader);
                                        return isMatchFound;
                                });
                System.out.println(malenBased);

                // Ques6
                System.out.println("\n Q6: Print all transaction's values from the traders living in Cambridge");

                transactions.stream()
                                .filter(transaction -> {
                                        Trader trader = new TraderFromTransaction().apply(transaction);
                                        Boolean isMatchFound = new CityPredicate("Cambridge").test(trader);
                                        return isMatchFound;
                                })
                                .collect(Collectors.groupingBy(Transaction::getValue,
                                                Collectors.mapping(Transaction::getTrader, Collectors.toList())))
                                .entrySet().stream().forEach(new ForEachConsumer<>());

                // Ques7
                System.out.println("\n Q7: What's the highest value of all the transactions");

                BinaryOperator<Integer> maxValue = BinaryOperator.maxBy((v1, v2) -> v1 > v2 ? 1 : v1 < v2 ? -1 : 0);
                int maxTransaction = transactions.stream()
                                .map(Transaction::getValue)
                                .reduce(0, maxValue);

                System.out.println(maxTransaction);

                // Ques8
                System.out.println("\n Q8: Find the transaction with the smallest value");

                int minTransaction = transactions.stream()
                                .map(Transaction::getValue)
                                .reduce(Integer.MAX_VALUE, Integer::min);

                System.out.println(minTransaction);
        }
}

class ForEachConsumer<T> implements Consumer<T> {

        @Override
        public void accept(T t) {
                System.out.println(t);
        }
}

class TransactionOf2011 implements Predicate<Transaction> {

        @Override
        public boolean test(Transaction t) {
                return t.getYear() == 2011;
        }
}

class ValueComparator implements Comparator<Transaction> {
        @Override
        public int compare(Transaction o1, Transaction o2) {
                return o1.getValue() - o2.getValue();
        }
}

class CityPredicate implements Predicate<Trader> {
        private String city;

        public CityPredicate(String city) {
                this.city = city;
        }

        @Override
        public boolean test(Trader t) {
                return t.getCity().equals(city);
        }
}

class TraderFromTransaction implements Function<Transaction, Trader> {
        @Override
        public Trader apply(Transaction t) {
                return t.getTrader();
        }
}

class TraderName implements Function<Trader, String> {
        @Override
        public String apply(Trader t) {
                return t.getName();
        }
}

class TraderCity implements Function<Transaction, String> {

        @Override
        public String apply(Transaction transaction) {
                return transaction.getTrader().getCity();
        }
}

class TraderNameFromTransaction implements Function<Transaction, String> {

        @Override
        public String apply(Transaction transaction) {
                return transaction.getTrader().getName();
        }
}
