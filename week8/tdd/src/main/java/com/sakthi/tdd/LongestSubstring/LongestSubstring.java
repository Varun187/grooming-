package com.sakthi.tdd.LongestSubstring;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    public static String findLongestSubstring(String str) {
        if(str == null){
            throw new IllegalArgumentException();
        }
        int n = str.length();
        int left = 0, right = 0;
        int maxLeft = 0, maxRight = 0;
        int maxlength = 0;
        Set<Character> checkSet = new HashSet<>();

        while (right < n) {
            char character = str.charAt(right);
            if (checkSet.contains(character)) {
                checkSet.remove(str.charAt(left));
                left++;
            } else {
                checkSet.add(character);
                right++;
                if (maxlength < right - left + 1) {
                    maxlength = right - left + 1;
                    maxLeft = left;
                    maxRight = right;
                }
            }
        }

        String result = "";
        for (int i = maxLeft; i < maxRight; i++) {
            result = result + str.charAt(i);
        }

        return result;
    }

    public static void main(String[] args) {
        String str = "sakthikumar";
        System.out.println(findLongestSubstring(str));
    }
}