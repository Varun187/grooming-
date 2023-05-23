package com.sakthi.tdd.trader_transaction;

import java.util.*;
import java.util.stream.Collectors;

public class TraderTransaction {

    public static List<Transaction> findTransactionsByYearAndSortByValue(List<Transaction> transactions, int year) {
        return transactions.stream()
                .filter(transaction -> transaction.getYear() == year)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
    }

    public static List<String> findUniqueCitiesOfTraders(List<Transaction> transactions) {
        return transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Trader> findTradersFromCityAndSortByName(List<Transaction> transactions, String city) {
        return transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals(city))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
    }

    public static String getAllTraderNamesSortedAlphabetically(List<Transaction> transactions) {
        return transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(" - "));
    }

    public static boolean areTradersBasedInCity(List<Transaction> transactions, String city) {
        return transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals(city));
    }

    public static List<Integer> getTransactionValuesFromTradersInCity(List<Transaction> transactions, String city) {
        return transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals(city))
                .map(Transaction::getValue)
                .collect(Collectors.toList());
    }

    public static int getHighestTransactionValue(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getValue)
                .max(Comparator.naturalOrder())
                .orElse(0);
    }

    public static Transaction getSmallestTransaction(List<Transaction> transactions) {
        return transactions.stream()
                .min(Comparator.comparing(Transaction::getValue))
                .orElse(null);
    }

}
