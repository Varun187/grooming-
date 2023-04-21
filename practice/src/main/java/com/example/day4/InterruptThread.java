package com.example.day4;

public class InterruptThread extends Thread{
    public void run(){
        try{
            System.out.println("thread running..");
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            System.out.println("thread interrupted!");
        }
    }
    public static void main(String[] args) {
        InterruptThread t1=new InterruptThread();
        t1.start();
        try{
            t1.interrupt();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
