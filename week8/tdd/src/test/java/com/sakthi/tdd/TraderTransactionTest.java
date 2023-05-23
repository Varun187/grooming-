package com.sakthi.tdd;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.sakthi.tdd.trader_transaction.Trader;
import com.sakthi.tdd.trader_transaction.TraderTransaction;
import com.sakthi.tdd.trader_transaction.Transaction;

class TraderTransactionTest {

    @Test
    void testFindTransactionsByYearAndSortByValue() {
        List<Transaction> transactions = getSampleTransactions();
        List<Transaction> expectedTransactions = Arrays.asList(
                new Transaction(new Trader("Brian", "Cambridge"), 2011, 300),
                new Transaction(new Trader("Raoul", "Cambridge"), 2011, 400));

        List<Transaction> actualTransactions = TraderTransaction.findTransactionsByYearAndSortByValue(transactions,
                2011);

        Assertions.assertEquals(expectedTransactions, actualTransactions);
    }

    @Test
    void testFindUniqueCitiesOfTraders() {
        List<Transaction> transactions = getSampleTransactions();
        List<String> expectedCities = Arrays.asList("Cambridge", "Milan");

        List<String> actualCities = TraderTransaction.findUniqueCitiesOfTraders(transactions);

        Assertions.assertEquals(expectedCities, actualCities);
    }

    @Test
    void testFindTradersFromCityAndSortByName() {
        List<Transaction> transactions = getSampleTransactions();
        List<Trader> expectedTraders = Arrays.asList(
                new Trader("Alan", "Cambridge"),
                new Trader("Brian", "Cambridge"),
                new Trader("Raoul", "Cambridge"));

        List<Trader> actualTraders = TraderTransaction.findTradersFromCityAndSortByName(transactions, "Cambridge");

        Assertions.assertEquals(expectedTraders, actualTraders);
    }

    @Test
    void testGetAllTraderNamesSortedAlphabetically() {
        List<Transaction> transactions = getSampleTransactions();
        String expectedNames = "Alan - Brian - Mario - Raoul";

        String actualNames = TraderTransaction.getAllTraderNamesSortedAlphabetically(transactions);

        Assertions.assertEquals(expectedNames, actualNames);
    }

    @Test
    void testAreTradersBasedInCity() {
        List<Transaction> transactions = getSampleTransactions();

        boolean tradersBasedInMilan = TraderTransaction.areTradersBasedInCity(transactions, "Milan");
        boolean tradersBasedInLondon = TraderTransaction.areTradersBasedInCity(transactions, "London");

        Assertions.assertTrue(tradersBasedInMilan);
        Assertions.assertFalse(tradersBasedInLondon);
    }

    @Test
    void testGetTransactionValuesFromTradersInCity() {
        List<Transaction> transactions = getSampleTransactions();
        List<Integer> expectedValues = Arrays.asList(300, 1000, 400, 950);

        List<Integer> actualValues = TraderTransaction.getTransactionValuesFromTradersInCity(transactions, "Cambridge");

        Assertions.assertEquals(expectedValues, actualValues);
    }

    @Test
    void testGetHighestTransactionValue() {
        List<Transaction> transactions = getSampleTransactions();
        int expectedValue = 1000;

        int actualValue = TraderTransaction.getHighestTransactionValue(transactions);

        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    void testGetSmallestTransaction() {
        List<Transaction> transactions = getSampleTransactions();
        Transaction expectedTransaction = new Transaction(new Trader("Brian", "Cambridge"), 2011, 300);

        Transaction actualTransaction = TraderTransaction.getSmallestTransaction(transactions);

        Assertions.assertEquals(expectedTransaction, actualTransaction);
    }

    private List<Transaction> getSampleTransactions() {
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
