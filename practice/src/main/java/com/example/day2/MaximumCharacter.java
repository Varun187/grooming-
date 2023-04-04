package com.example.day2;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaximumCharacter{
    static void countCharacters(String s){
        int i=0,temp,max=1;
        char c=s.charAt(0);
        HashMap<Character,Integer> count=new HashMap<Character,Integer>();
        s=s.toLowerCase();
        for(i=0;i<s.length();i++){
            if(count.containsKey(s.charAt(i))){
                temp=count.get(s.charAt(i));
                count.put(s.charAt(i),temp+1);
                if((temp+1)>max){
                    max=temp+1;
                    c=s.charAt(i);
                }
            }
            else{
                count.put(s.charAt(i),1);
            }
        }
        System.out.println("Character "+c+" occurs "+max+" times");
    }
    static void checkCharacters(String s) throws MyException{
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(s);

        if (matcher.find()) {
            throw new MyException("String should not contain special characters");
        }
    }
    public static void main(String[] args){
       System.out.println("Enter the word:");
       Scanner sc=new Scanner(System.in);
       String s=sc.next();
       try{
       checkCharacters(s);
       countCharacters(s);
       }
       catch(MyException e){
           e.printStackTrace();
       }
       sc.close();
    }
}
