package com.example.day1;

public class StringToEnum {
   enum Dogs{
        labrador,pug,beagle;
   }
   public static void main(String[] args){
       String dog="labrador";
       Dogs d=Dogs.valueOf(dog);
       System.out.println(d);
   }
}
