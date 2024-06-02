package AllLeetCodeContest;

import java.util.Arrays;

public class LeetCode3152_SpecialArrayII {
    public static void main(String[] args) {
        int [] nums1 = {3,4,2,1,6,8,9,7};
        int [][] queries1 = {{0,4}};
        int [] nums2 = {4,3,1,6};
        int [][] queries2 = {{0,2},{2,3}};
        int [] nums3 = {1,1};
        int [][] queries3 = {{0,1}};
        System.out.println(Arrays.toString(isArraySpecial(nums1, queries1)));
        System.out.println(Arrays.toString(isArraySpecial(nums2, queries2)));
        System.out.println(Arrays.toString(isArraySpecial(nums3, queries3)));
    }
    private static boolean[] isArraySpecial(int[] nums, int[][] queries){
        // fucking nice logic
        int n = nums.length;
        int[] sames = new int[n];
        for (int i = 1; i < n; ++i) {
            sames[i]=sames[i-1];
            if (nums[i]%2==nums[i-1]%2)
                sames[i]++;
        }
        boolean[] ans = new boolean[queries.length];
        for (int q = 0; q < queries.length; ++q) {
            if (sames[queries[q][1]]==sames[queries[q][0]])
                ans[q] = true;
        }
        return ans;
    }
}