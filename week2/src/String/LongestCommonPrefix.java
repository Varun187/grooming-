package String;

import java.util.Arrays;

//longest common prefix in a string
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strArray) {
        int i = 0;
        Arrays.sort(strArray);
        String str1 = strArray[0];
        String str2 = strArray[strArray.length-1];

        while (i < str1.length() && (str1.charAt(i) == str2.charAt(i))) {
            i++;
        }

        return str1.substring(0, i);
    }

    public static void main(String[] args) {
        String[] s = { "flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(s));
    }
}
