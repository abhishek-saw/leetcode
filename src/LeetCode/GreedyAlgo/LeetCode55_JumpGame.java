package GreedyAlgo;

public class LeetCode55_JumpGame {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};
        int[] nums3 = {2, 0, 0};
        System.out.println(canJump(nums1));
        System.out.println(canJump(nums2));
        System.out.println(canJump(nums3));
    }


    private static boolean canJump(int[] nums) {
        int maxIndex = 0;
        for(int i =0;i<nums.length;i++){
            if(i>maxIndex) {
                return false;
            }
            maxIndex = Math.max(maxIndex,i+nums[i]);
            if(maxIndex>=nums.length) {
                return true;
            }
        }
        return true;
    }
}