package Array;

import java.util.Arrays;

public class RunningSum {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4};
        System.out.println(Arrays.toString(runningSum(prices)));
    }

    private static int[] runningSum(int[] nums) {
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            nums[i] = sum + nums[i];
            sum = nums[i];
        }
        return nums;
    }
}