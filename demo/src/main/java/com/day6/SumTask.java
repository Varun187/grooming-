package com.day6;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Integer> {
    private int[] array;
    private int start;
    private int end;

    public SumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int length = end - start;
        if (length <= 10) {
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            System.out.println(Thread.currentThread().getName());
            return sum;
        }
        int mid = (start + end) / 2;
        SumTask lefTask = new SumTask(array, start, mid);
        SumTask righTask = new SumTask(array, mid, end);
        lefTask.fork();
        righTask.fork();
        // int rightSum = righTask.compute();
        int rightSum = righTask.join();
        int leftSum = lefTask.join();
        return leftSum + rightSum;

    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
        SumTask task = new SumTask(array, 0, array.length);
        int sum = forkJoinPool.invoke(task);
        System.out.println("The sum is : " + sum);

    }

}
