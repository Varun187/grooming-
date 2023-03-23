package com.modifiers;

public class hello {
    private int a;
    private String name;

    protected void show() {
        System.out.println("Hello java");
    }

    public int getA() {
        return a;
    }

    @Override
    public String toString() {
        return "hello [a=" + a + ", name=" + name + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setA(int a) {
        this.a = a;
    }

}
