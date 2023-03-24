package com.example.day1.visibility;


public class Example {
    private String a;
    public String getA() {
        return a;
    }
    public void setA(String a) {
        this.a = a;
    }
    public String b="public";
    protected String c="protected";
    String d="default";
    public void check(){
        Example e=new Example();
        e.setA("private");
        System.out.println(e.getA());
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
    public static void main(String[] args){
        Example e=new Example();
        e.check();
    }
}
