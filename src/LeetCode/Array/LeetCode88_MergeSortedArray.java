package Array;

import java.util.Arrays;

public class LeetCode88_MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2,5,6};
        int m1 = nums2.length;
        int n1 = nums2.length;
        int[] nums3 = {2,0};
        int[] nums4 = {1};
        int m3 = nums4.length;
        int n4 = nums4.length;
        merge(nums1, m1, nums2, n1);
        merge(nums3, m3, nums4, n4);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums3));

    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}
