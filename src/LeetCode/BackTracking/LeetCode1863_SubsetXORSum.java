package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode1863_SubsetXORSum {

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {5, 1, 6};
        int[] nums3 = {3, 4, 5, 6, 7, 8};
        //Best
        System.out.println(subsetXORSum(nums1));
        System.out.println(subsetXORSum(nums2));
        System.out.println(subsetXORSum(nums3));
        //making subsets : TC = O(2^N)
        //making subsets : SC = O(N)
        System.out.println(subsetXORSum1(nums1));
        System.out.println(subsetXORSum1(nums2));
        System.out.println(subsetXORSum1(nums3));
        //making subsets : TC = 2^N*length OF array
        //making subsets : SC = 2^N*length OF array
        System.out.println(subsetXORSum2(nums1));
        System.out.println(subsetXORSum2(nums2));
        System.out.println(subsetXORSum2(nums3));
        System.out.println(subsetXORSum3(nums1));
        System.out.println(subsetXORSum3(nums2));
        System.out.println(subsetXORSum3(nums3));
    }

    private static int subsetXORSum(int[] nums) {
        int xorALL = 0;
        for(Integer integer:nums){ //simple or then left shift as we want to add n-1 zeroes at last
            xorALL|=integer;
        }
        return xorALL << (nums.length - 1);
    }

    private static int subsetXORSum1(int[] nums) {
        return subsetsUsingXORBackTracking(nums, 0,0);
    }
    private static int subsetsUsingXORBackTracking(int[]nums, int index,int xor){
        if (index == nums.length) {
            return xor;
        }
        // calculate sum of xor with current element
        int withElement = subsetsUsingXORBackTracking(nums, index + 1, xor ^ nums[index]);
        // calculate sum of xor without current element
        int withoutElement = subsetsUsingXORBackTracking(nums, index + 1, xor);
        // return sum of xors from recursion
        return withElement + withoutElement;
    }
    private static int subsetXORSum2(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsetsUsingBackTracking(nums, 0,new ArrayList<>(),subsets);
        System.out.println(subsets);
        int sums = 0;
        for ( List<Integer> lists:subsets){
            int smallSum = 0;
            for (Integer integer:lists){
                smallSum = smallSum^integer;
            }
            sums+=smallSum;
        }
        return sums;
    }
    private static void subsetsUsingBackTracking(int[]nums, int index, List<Integer> currSubsets, List<List<Integer>> subsets){
        subsets.add(new ArrayList<>(currSubsets));
        for (int i = index; i < nums.length; i++) {
            // Include the current element in the subset
            currSubsets.add(nums[i]);
            // Move to the next element
            subsetsUsingBackTracking(nums, i + 1, currSubsets, subsets);
            // Exclude the current element (backtrack)
            currSubsets.remove(currSubsets.size() - 1);
        }
    }
    private static int subsetXORSum3(int[] nums) {
        int[][] subsets = subsetsUsingRecursion(nums, 0);
        System.out.println(Arrays.deepToString(subsets));
        int sums = 0;
        for (int[] arrays:subsets){
            int smallSum = 0;
            for (Integer integer:arrays){
                smallSum = smallSum^integer;
            }
            sums+=smallSum;
        }
        return sums;
    }
    private static int[][] subsetsUsingRecursion(int[] nums, int index) {
        if (index == nums.length) {
            return new int[1][0];
        }
        int[][] smallAnswer = subsetsUsingRecursion(nums, index + 1);
        int[][] answer = new int[2 * smallAnswer.length][];
        int k = 0;
        for (int[] arrays : smallAnswer) {
            answer[k] = new int[arrays.length];
            for (int j = 0; j < arrays.length; j++) {
                answer[k][j] = arrays[j];
            }
            k++;
        }
        for (int[] arrays : smallAnswer) {
            answer[k] = new int[arrays.length + 1];
            answer[k][0] = nums[index];
            for (int j = 0; j < arrays.length; j++) {
                answer[k][j + 1] = arrays[j];
            }
            k++;
        }

        return answer;
    }
}