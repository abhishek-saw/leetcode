package BackTracking;


import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        int n1 = 4;
        int k1 = 2;
        System.out.println(combine(n1,k1));

    }

    private static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        // use one from below only
        backTrackingCombinations1(n,k,1,new ArrayList<>(),answer);
        backTrackingCombinations2(n,k,1,new ArrayList<>(),answer);
        return answer;
    }
    private static void backTrackingCombinations1(int n, int k,int index, List<Integer> currList, List<List<Integer>> answer) {
        if (currList.size() == k){
            answer.add(new ArrayList<>(currList));
            return;
        }
        if(index==n+1) {
            return;
        }
        currList.add(index);
        backTrackingCombinations1(n, k, index + 1, currList, answer);
        currList.remove(currList.size() - 1);
        backTrackingCombinations1(n, k, index + 1, currList, answer);
    }
    private static void backTrackingCombinations2(int n, int k,int index, List<Integer> currList, List<List<Integer>> answer) {
        if (currList.size() == k){
            answer.add(new ArrayList<>(currList));
            return;
        }
        for(int i = index;i<=n;i++) {
            currList.add(i);
            backTrackingCombinations2(n, k, i + 1, currList, answer);
            currList.remove(currList.size() - 1);
        }
    }
}
