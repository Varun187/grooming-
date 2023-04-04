package com.example.day2;
final class Immutable {
    final int a;
    public Immutable(int a) {
        this.a = a;
    }
    public int getA() {
        return a;
    }
    public static void main(String[] args) {
        Immutable i=new Immutable(2);
        System.out.println(i.getA());
        //i.a=3;
    }
}
