package Array;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class LeetCode912_SortArray {
    public static void main(String[] args) {
       int[] nums1 = {5, 2, 3, 1};
        int[] nums2 = {5, 1, 1, 2, 0, 0};
        int[] nums3 = {-2,3,-5};
        System.out.println(Arrays.toString(sortArray(nums1)));
        System.out.println(Arrays.toString(sortArray(nums2)));
        System.out.println(Arrays.toString(sortArray(nums3)));

        System.out.println(Arrays.toString(sortArrayCount(nums1)));
        System.out.println(Arrays.toString(sortArrayCount(nums2)));
        System.out.println(Arrays.toString(sortArrayCount(nums3)));
    }

    private static int[] sortArrayCount(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for(int i : nums){
            max = Math.max(max,i);
            min = Math.min(min,i);
        }
        int[] count = new int[max-min+1];
        for(int i : nums){
            count[i-min]+=1;
        }
        int index =0 ;
        for (int j : count) {
            while (j > 0) {
                nums[index] = min;
                index++;
                j--;
            }
            min++;
        }
        return nums;
    }

    private static int[] sortArray(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums;
        }
        int n = nums.length;
        int[] arr1 = new int[n / 2];
        int[] arr2 = new int[n - arr1.length];
        System.arraycopy(nums, 0, arr1, 0, arr1.length);
        System.arraycopy(nums, arr1.length, arr2, 0, nums.length - arr1.length);
        int[] merge1 = sortArray(arr1);
        int[] merge2 = sortArray(arr2);
        return mergedSort(nums, merge1, merge2);
    }

    private static int[] mergedSort(int[] nums, int[] merge1, int[] merge2) {
        int m = merge1.length;
        int n = merge2.length;
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (merge1[i] < merge2[j]) {
                nums[k] = merge1[i];
                k++;
                i++;
            } else {
                nums[k] = merge2[j];
                k++;
                j++;
            }
        }
        while (i < m) {
            nums[k] = merge1[i];
            k++;
            i++;
        }
        while (j < n) {
            nums[k] = merge2[j];
            k++;
            j++;
        }
        return nums;
    }
}