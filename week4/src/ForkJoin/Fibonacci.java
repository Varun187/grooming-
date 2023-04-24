package ForkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

//Write a fork and join program to find the Fibonacci number by using recursive loop - RecursiveAction
public class Fibonacci {
    public static void main(String[] args) {
        int n = 5;
        FibonacciTask task = new FibonacciTask(n);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);
        System.out.println("The " + n + "th Fibonacci number" + " is " + task.getResult());
    }
}

class FibonacciTask extends RecursiveAction {
    private final int n;
    private long result;

    public FibonacciTask(int n) {
        this.n = n;
    }

    public long getResult() {
        return result;
    }

    @Override
    protected void compute() {
        if (n <= 1) {
            result = n;
        } else {
            FibonacciTask leftTask = new FibonacciTask(n - 1);
            FibonacciTask rightTask = new FibonacciTask(n - 2);
            leftTask.fork();
            rightTask.compute();
            leftTask.join();
            result = leftTask.getResult() + rightTask.getResult();
        }
    }
}