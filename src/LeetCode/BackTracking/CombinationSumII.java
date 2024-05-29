package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class CombinationSumII {
    public static void main(String[] args) {
        int [] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates,target));
    }

    private static  List<List<Integer>> combinationSum2(int[] candidates,int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(candidates);
        backTracking(candidates,0,target,new ArrayList<>(),combinations);
        return combinations;
    }

    private static void backTracking(int[] candidates, int index,int target, List<Integer> currList, List<List<Integer>> combinations) {
        if (target==0){
            if(combinations.contains(currList)){
                return;
            }
            combinations.add(new ArrayList<>(currList));
        } else {
            for (int i = index; i < candidates.length - 1; i++) {
                if(i > index && candidates[i] == candidates[i-1]) {
                    continue;
                }
                if(candidates[i]>target){
                    break;
                }
                currList.add(candidates[i]);
                backTracking(candidates, i + 1, target - candidates[i], currList, combinations);
                currList.remove(currList.size() - 1);
            }
        }
    }
}
