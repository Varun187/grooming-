import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* find the maximum occurring character in a given String and try to use exception handling for edge cases? */

public class MaximumCharacter {

    static List<Character> getMaxCharacter(String str) {
        

        int length = str.length();
        int frequency[] = new int[256];
        
        for (int i = 0; i < length; i++)
            frequency[str.charAt(i)]++;

        int max = -1; 
        List<Character> result = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            if (max < frequency[str.charAt(i)]) {
                max = frequency[str.charAt(i)];
                result.clear();
                result.add(str.charAt(i));
            }
            else if(max == frequency[str.charAt(i)] && !result.contains(str.charAt(i))){
                result.add(str.charAt(i));
            }
        }

        return result;

    }

    public static void main(String[] args) {
        String str = "aabb";
        try{
            if(str.isBlank())
                System.out.println("The string is empty");
            else{
                List<Character> result = getMaxCharacter(str);
                for(char c : result)
                    System.out.println("Maximum occurring character is "+ c);
            }
        }catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
