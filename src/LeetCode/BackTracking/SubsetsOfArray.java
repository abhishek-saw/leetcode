package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetsOfArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {5, 1, 6};
        int[] nums3 = {3, 4, 5, 6, 7, 8};
        System.out.println(subsetsBackTracking(nums1));
        System.out.println(subsetsBackTracking(nums2));
        System.out.println(subsetsBackTracking(nums3));
    }
    private static List<List<Integer>> subsetsBackTracking(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        allSubsets(nums,0,new ArrayList<>(),subset);
        return subset;
    }
    public static void allSubsets(int[] nums, int index, List<Integer> currList, List<List<Integer>> subset){
        subset.add(new ArrayList<>(currList));
        for(int i =index;i<nums.length;i++){
            currList.add(nums[i]);
            allSubsets(nums,i+1,currList,subset);
            currList.remove(currList.size()-1);
        }
    }
}