package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class LeetCode118_PascalTriangle {
    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> answer1 = generate1(numRows);
        for(List<Integer> ans : answer1) {
            System.out.println(ans);
        }
        List<List<Integer>> answer2 = generate2(numRows);
        for(List<Integer> ans : answer2) {
            System.out.println(ans);
        }
    }

    private static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> output = new ArrayList<>();
        if (numRows <= 0)  return output;
        ArrayList<Integer> prev = new ArrayList<>();
        prev.add(1);
        output.add(prev);
        for (int i = 2; i <= numRows; i++) {
            ArrayList<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int j = 0; j < prev.size() - 1; j++) {
                curr.add(prev.get(j) + prev.get(j + 1));
            }
            curr.add(1);
            output.add(curr);
            prev = curr;
        }
        return output;
    }

    public static List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        for(int i =0;i<numRows;i++){
            List<Integer> row = new ArrayList<>();
            for (int j = 0;j<=i;j++){
                row.add((int)ncr(i,j));
            }
            answer.add(row);
        }
        return answer;
    }
    private static long ncr(int n,int r){
        int answer = 1;
        for (int i=0;i<r;i++){
            answer*=(n-i);
            answer/=(i+1);
        }
        return answer;
    }
}
