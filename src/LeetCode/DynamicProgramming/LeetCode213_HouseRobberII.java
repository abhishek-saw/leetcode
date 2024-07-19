package DynamicProgramming;


import java.util.Arrays;

public class LeetCode213_HouseRobberII {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 2};
        int[] nums2 = {1,2,3,1};
        int[] nums3 = {1,2,3};
        int[] nums4 = {1,7,9,2};
        System.out.println(rob(nums1));
        System.out.println(rob(nums2));
        System.out.println(rob(nums3));
        System.out.println(rob(nums4));
    }

    private static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        // Calculate the maximum amount that can be robbed from the two scenarios
        int robFirstToSecondLast = robHelper(nums, 0, nums.length - 2);
        int robSecondToLast = robHelper(nums, 1, nums.length - 1);
        // Return the maximum of the two scenarios
        return Math.max(robFirstToSecondLast, robSecondToLast);
    }

    private static int robHelper(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }

        // Initialize dp array to store maximum amounts
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        // Fill the dp array with the maximum amounts that can be robbed up to each house
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        // Return the maximum amount that can be robbed up to the end house
        return dp[end];
    }
}
