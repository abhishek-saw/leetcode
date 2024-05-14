package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;
        System.out.println(combinationSumRecursion(candidates, target));
        System.out.println(combinationSumBackTracking(candidates,target));
    }

    private static List<List<Integer>> combinationSumBackTracking(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        backTracking(candidates,target,0,new ArrayList<>(),answer);
        return answer;
    }

    private static void backTracking(int[] candidates, int target, int index, List<Integer> smallAnswer, List<List<Integer>> answer) {
        if(target<0){
            return;
        }
        if(target==0){
            answer.add(new ArrayList<>(smallAnswer));
        }
        for (int i =index;i<candidates.length;i++){
            smallAnswer.add(candidates[i]);
            backTracking(candidates,target-candidates[i],i,smallAnswer,answer);
            smallAnswer.remove(smallAnswer.size()-1);
        }
    }

    private static List<List<Integer>> combinationSumRecursion(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        combinations(candidates,target,0,new ArrayList<>(),answer);
        return answer;
    }

    private static void combinations(int[] candidates, int target, int index, List<Integer> smallAnswer, List<List<Integer>> answer) {
        if (target<0){
            return;
        }
        if(index==candidates.length){
            if(target==0){
                answer.add(new ArrayList<>(smallAnswer));
            }
            return;
        }
        if(candidates[index]<=target){
            smallAnswer.add(candidates[index]);
            combinations(candidates,target-candidates[index],index,smallAnswer,answer);
            smallAnswer.remove(smallAnswer.size()-1);
        }
        combinations(candidates,target,index+1,smallAnswer,answer);
    }
}