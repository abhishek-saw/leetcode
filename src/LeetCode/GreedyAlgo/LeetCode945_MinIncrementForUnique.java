package GreedyAlgo;

import java.util.Arrays;

public class LeetCode945_MinIncrementForUnique {
    public static void main(String[] args) {
        int [] nums1 = {1,2,2};
        int [] nums2 = {3,2,1,2,1,7};
        System.out.println(minIncrementForUnique(nums1));
        System.out.println(minIncrementForUnique(nums2));
        System.out.println(minIncrementForUniqueBetter(nums1));
        System.out.println(minIncrementForUniqueBetter(nums2));
    }

    private static int minIncrementForUniqueBetter(int[] nums) {
        int max = findMax(nums);
        int [] freq =  new int[max+nums.length];
        for(int num:nums){
            freq[num]++;
        }
        int count = 0;
        for(int i =0;i<freq.length;i++){
            if(freq[i]<=1){
                continue;
            }
            int diff = freq[i]-1;
            freq[i+1]+=diff;
            freq[i] = 1;
            count+=diff;
        }
        return count;
    }
    private static int findMax(int[] array) {
        int max = Integer.MIN_VALUE;
        for(int i :array){
            max = Math.max(max,i);
        }
        return max;
    }

    private static int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int count =0;
        for(int i =1;i<nums.length;i++){
            if(nums[i]<=nums[i-1]){
                int diff = Math.abs(nums[i] - nums[i-1]);
                count+=diff+1;
                nums[i] += diff+1;
            }
        }
        return count;
    }
}
