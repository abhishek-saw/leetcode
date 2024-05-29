package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public static void main(String[] args) {
        int [] nums1 = {1,2,2};
        int [] nums2 = {0};
        System.out.println(subsetsWithDup(nums1));
        System.out.println(subsetsWithDup(nums2));

    }

    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(nums,0,new ArrayList<>(),answer);
        return answer;
    }

    private static void backtracking(int[] nums, int index, List<Integer> currList, List<List<Integer>> answer) {
        answer.add(new ArrayList<>(currList));
        for (int i =index;i<nums.length;i++) {
            if(i>index && nums[i]==nums[i-1]){
                continue;
            }
            currList.add(nums[i]);
            backtracking(nums, i+1, currList, answer);
            currList.remove(currList.size() - 1);
        }
    }
}
