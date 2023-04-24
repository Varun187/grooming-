package ForkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

//Write a fork and join program to sum all the numbers from a range.- RecursiveTask
public class SumWithinRange {
    public static void main(String[] args) {
        Integer[] numbers = new Integer[100];
        for (int i = 1; i <= numbers.length; i++) {
            numbers[i - 1] = i;
        }
        int startIndex = 0;
        int endIndex = 15;
        SumRangeTask task = new SumRangeTask(numbers, startIndex, endIndex);
        ForkJoinPool pool = ForkJoinPool.commonPool();
        long result = pool.invoke(task);
        System.out
                .println("The sum of numbers with range " + startIndex + " " + endIndex + " in the array is " + result);
    }
}

class SumRangeTask extends RecursiveTask<Integer> {
    private static final Integer THRESHOLD = 10;
    private final Integer[] numbers;
    private final int start;
    private final int end;

    public SumRangeTask(Integer[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int count = end - start + 1;
        if (count <= THRESHOLD) {
            Integer sum = 0;
            for (int i = start; i < end; i++) {
                sum += numbers[i];
            }
            return sum;
        } else {
            int mid = start + count / 2;
            SumRangeTask leftTask = new SumRangeTask(numbers, start, mid);
            SumRangeTask rightTask = new SumRangeTask(numbers, mid, end);
            leftTask.fork();
            Integer rightResult = rightTask.compute();
            Integer leftResult = leftTask.join();
            return leftResult + rightResult;
        }
    }

}