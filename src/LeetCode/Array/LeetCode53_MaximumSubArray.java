package Array;

public class LeetCode53_MaximumSubArray {
    public static void main(String[] args) {
        int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums2 = {1};
        int[] nums3 = {5,4,-1,7,8};
        int[] nums4 = {-1};
        System.out.println(maxSubArray(nums1));
        System.out.println(maxSubArray(nums2));
        System.out.println(maxSubArray(nums3));
        System.out.println(maxSubArray(nums4));
    }

    private static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            maxSum = Math.max(sum, maxSum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}
