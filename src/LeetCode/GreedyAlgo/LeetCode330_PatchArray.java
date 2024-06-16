package GreedyAlgo;

public class LeetCode330_PatchArray {
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int n1 = 6;
        int[] nums2 = {1,5,10};
        int n2 = 20;
        int[] nums3 = {1,2,2};
        int n3 = 5;
        System.out.println(minPatches(nums1,n1));
        System.out.println(minPatches(nums2,n2));
        System.out.println(minPatches(nums3,n3));
    }

    private static int minPatches(int[] nums, int n) {
        int patch = 0;
        long maxReach = 0;
        int index = 0;
        while (maxReach<=n){
            if(index<nums.length && nums[index]<=maxReach+1 ){
                maxReach+=nums[index];
                index++;
            }
            else {
                maxReach+=maxReach+1;
                patch++;
            }
        }
        return patch;
    }
}
