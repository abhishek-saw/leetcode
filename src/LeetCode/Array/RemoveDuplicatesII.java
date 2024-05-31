package Array;

import java.util.Arrays;

public class RemoveDuplicatesII {
    public static void main(String[] args) {
        int[] nums1 = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(nums1));
        System.out.println(removeDuplicates(nums1));
        System.out.println(Arrays.toString(nums1));
        int[] nums2 = {0,0,1,1,1,1,2,3,3};
        System.out.println(Arrays.toString(nums2));
        System.out.println(removeDuplicates(nums2));
        System.out.println(Arrays.toString(nums2));
    }

    private static int removeDuplicates(int[] nums) {
        int candidate = 0;
        int count = 0;
        int index = 0;
        for(int num:nums){
            if(candidate==num){
                count++;
            }
            else {
                candidate = num;
                count=1;
            }
            if(count<=2){
                nums[index++] = candidate;
            }
        }
        return index;
    }
}