package com.sakthi.tdd.MaxOccuringCharacter;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaxOccurringCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your string: ");

        try {
            String input = scanner.next();
            char maxOccurringCharacter = findMaxOccurringCharacter(input);
            System.out.println("Max occurring character is : " + maxOccurringCharacter);
            System.out.println(
                    "Frequency of maxOccurring character is: " + countOccurrences(input, maxOccurringCharacter));
        } catch (InvalidCharacterException ex) {
            System.out.print("Caught exception with message: ");
            System.out.print(ex.getMessage());
        }

        scanner.close();
    }

    public static char findMaxOccurringCharacter(String input) throws InvalidCharacterException {
        Pattern p = Pattern.compile("[^A-Za-z]");
        Matcher m = p.matcher(input);

        if (m.find()) {
            throw new InvalidCharacterException("Input should only have alphabetical characters-[A-Za-z]");
        }
        input = input.toLowerCase();

        int[] cnt = new int[26];

        char maxOccurringCharacter = 0;
        int mx = Integer.MIN_VALUE;

        for (int i = 0; i < input.length(); i++) {
            cnt[input.charAt(i) - 'a']++;
        }

        for (int i = 0; i < input.length(); i++) {
            int i1 = cnt[input.charAt(i) - 'a'];
            if (mx < i1) {
                mx = i1;
                maxOccurringCharacter = input.charAt(i);
            }
        }

        return maxOccurringCharacter;
    }

    public static int countOccurrences(String input, char character) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == character) {
                count++;
            }
        }
        return count;
    }
}
