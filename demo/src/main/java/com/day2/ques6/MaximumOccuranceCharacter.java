package com.day2.ques6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaximumOccuranceCharacter {
    public static void main(String[] args) {
        String str = "Helloworld*@";
        str = str.toLowerCase();
        char maxChar;
        try {
            checkSpecialCharacters(str);
            maxChar = getMaxOccurringChar(str);
            System.out.println("The maximum occurring character is " + maxChar);
        } catch (MyException e) {
            // e.printStackTrace();

            // multi catch - new features
            // exception propagation
            // try with resource
            // finalize
        }
    }

    public static void checkSpecialCharacters(String str) throws MyException {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {
            throw new MyException("String should not contain Special Characters");
        }
    }

    public static char getMaxOccurringChar(String str) throws MyException {
        if (str == null || str.isEmpty()) {
            throw new MyException("Input string cannot be null or empty.");
        }
        int[] charCounts = new int[256];
        for (int i = 0; i < str.length(); i++) {
            charCounts[str.charAt(i)]++;
        }
        int maxCount = -1;
        char maxChar = ' ';
        for (int i = 0; i < charCounts.length; i++) {
            if (charCounts[i] > maxCount) {
                maxCount = charCounts[i];
                maxChar = (char) i;
            }
        }
        return maxChar;
    }
}
