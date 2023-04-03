package Set;

import java.util.HashSet;
import java.util.Set;

//Longest substring without repeating characters
public class LongestSubstring {

    public static void findLongestSubstring(String str) {
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

        for (int i = maxLeft; i < maxRight; i++) {
            System.out.print(str.charAt(i) + " ");
        }

    }

    public static void main(String[] args) {
        String str = "sakthikumar";
        findLongestSubstring(str);
    }
}
