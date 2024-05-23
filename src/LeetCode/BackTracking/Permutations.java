package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        permuteBT(nums,new ArrayList<>(),permutations);
        return permutations;
    }

    private static void permuteBT(int[] nums, List<Integer> currList, List<List<Integer>> permutations) {
        if(nums.length==currList.size()){
            permutations.add(new ArrayList<>(currList));
        }
        else {
            for (int num : nums) {
                if (currList.contains(num)){
                    continue;
                }
                currList.add(num);
                permuteBT(nums, currList, permutations);
                currList.remove(currList.size() - 1);
            }
        }
    }
}
