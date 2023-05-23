package com.sakthi.tdd.LongestPalindrome;

public class LongestPalindrome {

    public static int longestPalindrome(String str) {
        if(str == null || str.isBlank()){
            return 0;
        }

        if(str.length() == 1){
            return 1;
        }

        str = str.replace(" ", "").toLowerCase();
        int n = str.length();
        String result = "";
        int j;
        String substring = "";

        String reversed = "";
        for (int i = 0; i < n; i++) {
            j = n - 1;
            while (i < j) {
                if (str.charAt(i) == str.charAt(j) && result.length() < (j - i + 1)) {
                    substring = str.substring(i, j + 1);
                    reversed = new StringBuilder(substring).reverse().toString();
                    if (substring.equals(reversed)) {
                        result = substring;
                    }
                }
                j--;
            }
        }

        System.out.println("Longest palindrome substring is: " + result);
        return result.length();
    }

    public static void main(String[] args) {
        String str = "sealaemydnfkfa";
        System.out.println("Length is: " + longestPalindrome(str));
    }
}