package com.start;

public class StringToEnum {
    enum Tech {
        JAVA, REACT, PYTHON, SPRINGBOOT, CLOUD;
    }

    public static void main(String[] args) {
        String str = "JAVA";
        Tech tech = Tech.valueOf(str);

        System.out.println("The tech is " + tech);
    }

}
