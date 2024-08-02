package Array;

import java.util.Arrays;

public class LeetCode2134_MinSwaps {
    public static void main(String[] args) {
        int[] nums1 = {0,1,0,1,1,0,0};
        int[] nums2 = {0,1,1,1,0,0,1,1,0};
        int[] nums3 = {1,1,0,0,1};
        System.out.println(minSwaps(nums1));
        System.out.println(minSwaps(nums2));
        System.out.println(minSwaps(nums3));
    }

    private static int minSwaps(int[] nums) {
        int n = nums.length;
        int count1 = 0;
        for (int i : nums){
            if(i==1){
                count1++;
            }
        }
        int swaps = Integer.MAX_VALUE;
        int countZero = 0;
        for (int i = 0;i<count1;i++){
            if(nums[i]==0){
                countZero++;
            }
        }
        int s = 0;
        int end = count1-1;
        int[] array = new int[nums.length*2];
        System.arraycopy(nums, 0, array, 0,n);
        System.arraycopy(nums, 0, array,n,n);
        System.out.println(Arrays.toString(array));
        while (end<array.length-1){
            swaps = Math.min(swaps,countZero);
            s++;
            end++;
            if(array[s-1]==0){
                countZero--;
            }
            if(array[end]==0){
                countZero++;
            }
        }
        return swaps;
    }
}
