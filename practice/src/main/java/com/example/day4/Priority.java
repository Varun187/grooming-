package com.example.day4;

class Priority extends Thread{
    public void run(){
        System.out.println(this.getName()+" with priority "+this.getPriority()+" is running");
    }
    
    public static void main(String[] args) {
        Priority t1=new Priority();
        Priority t2=new Priority();
        Priority t3=new Priority();
        System.out.println("Priority:\nT1: "+t1.getPriority()+"\nT2: "+t2.getPriority()+"\nT3: "+t3.getPriority());
        t1.setPriority(3);
        t2.setPriority(6);
        t3.setPriority(7);
        System.out.println("Priority:\nT1: "+t1.getPriority()+"\nT2: "+t2.getPriority()+"\nT3: "+t3.getPriority());
        t1.start();
        t2.start();
        t3.start();
    }
}
