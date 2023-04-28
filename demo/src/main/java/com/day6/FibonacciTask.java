package com.day6;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class FibonacciTask extends RecursiveAction {
    private int n;
    private int result;

    public FibonacciTask(int n) {
        this.n = n;
    }

    public int getResult() {
        return result;
    }

    @Override
    protected void compute() {
        if (n <= 10) {
            result = fibonacci(n);
        } else {
            FibonacciTask left = new FibonacciTask(n - 1);
            FibonacciTask right = new FibonacciTask(n - 2);
            left.fork();
            right.compute();
            left.join();
            result = left.result + right.result;
        }
    }

    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        FibonacciTask task = new FibonacciTask(12);
        forkJoinPool.invoke(task);
        System.out.println(task.getResult());
    }
}
