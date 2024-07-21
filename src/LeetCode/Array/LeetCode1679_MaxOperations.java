package Array;

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode1679_MaxOperations {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4};
        int k1 = 5;
        int[] nums2 = {3,1,3,4,3};
        int k2 = 6;
        System.out.println(maxOperations(nums1,k1));
        System.out.println(maxOperations(nums2,k2));
        System.out.println(maxOperationsBetter(nums1,k1));
        System.out.println(maxOperationsBetter(nums2,k2));
    }

    private static int maxOperationsBetter(int[] nums, int k) {
        HashMap<Integer,Integer> maps = new HashMap<>();
        int count = 0;
        for (int number : nums) {
            if (maps.containsKey(k - number) && maps.get(k - number) > 0) {
                count++;
                maps.put(k - number, maps.get(k - number) - 1);
            } else {
                maps.put(number, maps.getOrDefault(number, 0) + 1);
            }
        }
        return count;
    }

    private static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length-1;
        int operations = 0;
        while (start<end){
            if(nums[start]+nums[end]==k){
                operations++;
                start++;
                end--;
            }
            else if (nums[start]+nums[end]>k){
                end--;
            }
            else {
                start++;
            }
        }
        return operations;
    }
}
