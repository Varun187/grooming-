package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TraderTransaction {
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
        System.out.println("\n Qn1: Find all transactions in the year 2011 and sort them by value (small to high)");
        transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // ques2
        System.out.println("\n Qn2: What are all the unique cities where the traders work?");

        transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // ques3
        System.out.println("\n Qn3: Find all traders from Cambridge and sort them by name");

        transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // ques4
        System.out.println("\n Q4: Return a string of all trader's names sorted alphabetically");

        String traderNames = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + " - " + n2);

        System.out.println(traderNames);

        // ques5
        System.out.println("\n Q5: Are any traders based in Milan?");

        boolean malenBased = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(malenBased);

        // Ques6
        System.out.println("\n Q6: Print all transaction's values from the traders living in Cambridge");

        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .collect(Collectors.groupingBy(Transaction::getValue,
                        Collectors.mapping(Transaction::getTrader, Collectors.toList())))
                .entrySet().stream().forEach(System.out::println);

        // Ques7
        System.out.println("\n Q7: What's the highest value of all the transactions");

        int maxTransaction = transactions.stream()
                .map(Transaction::getValue)
                .reduce(0, Integer::max);

        System.out.println(maxTransaction);

        // Ques8
        System.out.println("\n Q8: Find the transaction with the smallest value");

        int minTransaction = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer.MAX_VALUE, Integer::min);

        System.out.println(minTransaction);
    }
}

class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return this.trader;
    }

    public int getYear() {
        return this.year;
    }

    public int getValue() {
        return this.value;
    }

    public String toString() {
        return "{" + this.trader + ", " +
                "year: " + this.year + ", " +
                "value:" + this.value + "}";
    }
}

class Trader {
    private final String name;
    private final String city;

    public Trader(String n, String c) {
        this.name = n;
        this.city = c;
    }

    public String getName() {
        return this.name;
    }

    public String getCity() {
        return this.city;
    }

    public String toString() {
        return "Trader:" + this.name + " in " + this.city;
    }
}
