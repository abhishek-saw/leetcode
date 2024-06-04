package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode47_PermutationsII {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        System.out.println(permuteUnique(nums1));
        int[] nums2 = {1,1,2};
        System.out.println(permuteUnique(nums2));
    }

    private static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> permutations = new ArrayList<>();
        backTracking(nums,0,permutations,new ArrayList<>(),new boolean[nums.length]);
        return permutations;
    }

    private static void backTracking(int[] nums, int index, List<List<Integer>> permutations, List<Integer> currList, boolean[] visited) {
        if(currList.size()==nums.length){
                permutations.add(new ArrayList<>(currList));
        }
        else {
            for(int i =0;i<nums.length;i++) {
                if(visited[i]){
                    continue;
                }
                if(i>0 && visited[i-1] && nums[i]==nums[i-1]){
                    continue;
                }
                currList.add(nums[i]);
                visited[i]= true;
                backTracking(nums, i + 1, permutations, currList, visited);
                currList.remove(currList.size() - 1);
                visited[i] =false;
            }
        }
    }
}
