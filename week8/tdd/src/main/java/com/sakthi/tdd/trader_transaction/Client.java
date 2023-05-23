package com.sakthi.tdd.trader_transaction;

import java.util.Arrays;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<Transaction> transactions = getSampleTransactions();

        // ques1
        System.out.println("\n Qn1: Find all transactions in the year 2011 and sort them by value (small to high)");
        List<Transaction> transactions2011 = TraderTransaction.findTransactionsByYearAndSortByValue(transactions, 2011);
        transactions2011.forEach(System.out::println);

        // ques2
        System.out.println("\n Qn2: What are all the unique cities where the traders work?");
        List<String> uniqueCities = TraderTransaction.findUniqueCitiesOfTraders(transactions);
        uniqueCities.forEach(System.out::println);

        // ques3
        System.out.println("\n Qn3: Find all traders from Cambridge and sort them by name");
        List<Trader> tradersFromCambridge = TraderTransaction.findTradersFromCityAndSortByName(transactions, "Cambridge");
        tradersFromCambridge.forEach(System.out::println);

        // ques4
        System.out.println("\n Q4: Return a string of all trader's names sorted alphabetically");
        String traderNames = TraderTransaction.getAllTraderNamesSortedAlphabetically(transactions);
        System.out.println(traderNames);

        // ques5
        System.out.println("\n Q5: Are any traders based in Milan?");
        boolean tradersBasedInMilan = TraderTransaction.areTradersBasedInCity(transactions, "Milan");
        System.out.println(tradersBasedInMilan);

        // Ques6
        System.out.println("\n Q6: Print all transaction's values from the traders living in Cambridge");
        List<Integer> transactionValuesCambridge = TraderTransaction.getTransactionValuesFromTradersInCity(transactions, "Cambridge");
        transactionValuesCambridge.forEach(System.out::println);

        // Ques7
        System.out.println("\n Q7: What's the highest value of all the transactions");
        int maxTransaction = TraderTransaction.getHighestTransactionValue(transactions);
        System.out.println(maxTransaction);

        // Ques8
        System.out.println("\n Q8: Find the transaction with the smallest value");
        Transaction smallestTransaction = TraderTransaction.getSmallestTransaction(transactions);
        System.out.println(smallestTransaction);
    }

    private static List<Transaction> getSampleTransactions() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        return Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));
    }
}
