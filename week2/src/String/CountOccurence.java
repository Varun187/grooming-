package String;

public class CountOccurence {
    public static void main(String[] args) {
        String str = "srinivasan";
        countOccurenceInAlphaOrder(str);
        countOccurenceInGivenOrder(str);
    }

    private static int[] countOccurence(String str) {
        int[] count = new int[26];
        int n = str.length();
        for (int i = 0; i < n; i++) {
            count[str.charAt(i) - 'a']++;
        }
        return count;
    }

    private static void countOccurenceInGivenOrder(String str) {
        int[] count = countOccurence(str);
        System.out.println("count of characters in the order available in the string ");
        for (int i = 0; i < str.length(); i++) {
            char character = str.charAt(i);
            if (count[character - 'a'] != 0){
                System.out.print(character + ":" + count[character - 'a'] + " ");
                count[character - 'a'] = 0;
            }
        }
        System.out.println();
    }

    private static void countOccurenceInAlphaOrder(String str) {
        int[] count = countOccurence(str);
        System.out.println("count of characters in the alphabetical order ");
        for (int i = 0; i < 26; i++) {
            char character = (char) ('a' + i);
            if (count[i] != 0)
                System.out.print(character + ":" + count[i] + " ");
        }
        System.out.println();
    }
}
