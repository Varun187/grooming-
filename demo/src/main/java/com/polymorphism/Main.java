package com.polymorphism;

public class Main {
    public static void main(String[] args) {
        Samsung s1 = new Samsung();
        Samsung s2 = new M53();
        Samsung s3 = new A53();

        s1.model();
        s1.model("5G");
        s2.model();
        s3.model();

    }
}
