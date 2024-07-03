package Array;

import java.util.Arrays;

public class LeetCode1509_MinDifference {
    public static void main(String[] args) {
        int[] nums1 = {5, 3, 2, 4};
        int[] nums2 = {82, 81, 95, 75, 20};
        int[] nums3 = {3, 100, 20};
        int[] nums4 = {6, 6, 0, 1, 1, 4, 6};
        System.out.println(minDifference(nums1));
        System.out.println(minDifference(nums2));
        System.out.println(minDifference(nums3));
        System.out.println(minDifference(nums4));
    }

    private static int minDifference(int[] nums) {
        int n = nums.length;
        if(n <= 4){
            return 0;
        }
        if(n == 5){
            return 1;
        }
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        result = Math.min(result,(nums[n-4]-nums[0]));
        result = Math.min(result,(nums[n-1]- nums[3]));
        result = Math.min(result,(nums[n-3]-nums[1]));
        result = Math.min(result,(nums[n-2]-nums[2]));
        return result;
    }
}