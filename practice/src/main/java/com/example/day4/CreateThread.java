package com.example.day4;

public class CreateThread extends Thread{
    static int count=0;
    public void run(){
        System.out.println("thread is running");
        count++;
    }
    public static void main(String[] args) {
        CreateThread t=new CreateThread();
        t.start();
        // while(t.isAlive()){
        //     System.out.println("Waiting...");
        // }
        System.out.println(count);
    }
}
