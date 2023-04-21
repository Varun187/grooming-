package com.example.day4;

public class CreateTask implements Runnable{

    @Override
    public void run() {
        System.out.println("Thread running..");
        for(int i=0;i<5;i++){
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        CreateTask t=new CreateTask();
        Thread t1=new Thread(t);
        t1.start();
    }
}
