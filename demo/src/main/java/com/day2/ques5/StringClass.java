package com.day2.ques5;

public class StringClass {
    public static void main(String[] args) {
        // String Builder
        // StringBuffer is thread-safe so used in multi threading
        StringBuilder string1 = new StringBuilder();
        string1.append("String");
        string1.append("Builder");
        string1.replace(6, 13, "Java");
        System.out.println(string1.toString());

        // String Buffer
        // mainly used in single-threaded environment for better performance
        StringBuffer string2 = new StringBuffer();
        string2.append("String");
        string2.append("Buffer");
        string2.insert(6, ", ");
        System.out.println(string2.toString());
    }

}
