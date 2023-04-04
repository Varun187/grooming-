package com.example.day1;

public class StringToEnum {
   enum Dogs{
        LABRADOR,PUG,BEAGLE;
   }
   public static void main(String[] args){
       String dog="LABRADOR";
       Dogs d=Dogs.valueOf(dog);
       System.out.println(d);
   }
}
