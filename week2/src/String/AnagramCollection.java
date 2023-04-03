package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given a sequence of space separated words in string, print all anagrams together 
public class AnagramCollection {
    public static void main(String[] args) {
        String  str = "act doc tac mat tam cod act";
        anagramCollection(str);
    }

    private static void anagramCollection(String str) {
        Map<String, List<String>> map = new HashMap<>();

        String[] array =  str.split(" ");
        for (int i = 0; i < array.length; i++) {
            String word = array[i];  
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray); 
            String sortedWord = new String(charArray);
            
            if(!map.containsKey(sortedWord)){
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(sortedWord, list);
            }else{
                map.get(sortedWord).add(word);
            }
        }

        for (String key : map.keySet()) {
            List<String> values = map.get(key);
            if(values.size() > 1){
                System.out.println(values);
            }
        }
    }
}
