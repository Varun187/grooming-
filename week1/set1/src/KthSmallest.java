import java.util.Arrays;

public class KthSmallest {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 5, 6, 4 };
        int k = 2;
        /* method 1 */
        Arrays.sort(nums);
        System.out.println(nums[k - 1]);
       
        /* method 2 */
        App obj = new App();
        int result = obj.find(nums, k);
        System.out.println(result);
    }
}

class App {
    public int find(int[] nums, int k) {
        int start = 0, end = nums.length - 1, findIndex = k - 1;
        while (start < end) {
            int pivot = partion(nums, start, end);
            if (pivot < findIndex)
                start = pivot + 1;
            else if (pivot > findIndex)
                end = pivot - 1;
            else
                return nums[pivot];
        }
        return nums[findIndex];
    }

    private int partion(int[] nums, int start, int end) {
        int p = start;
        int pivot = nums[end];
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, p);
                p += 1;
            }
        }
        swap(nums, end, p);
        return p;
    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

}
