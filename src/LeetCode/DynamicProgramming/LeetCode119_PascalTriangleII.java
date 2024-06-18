package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class LeetCode119_PascalTriangleII {
    public static void main(String[] args) {
        int rowIndex = 30;
        System.out.println(getRow(rowIndex));
    }

    private static List<Integer> getRow(int rowIndex) {
        List<Integer> answer = new ArrayList<>();
        for(int i =0;i<rowIndex;i++){
            answer.add((int)ncr(rowIndex,i));
        }
        return answer;
    }

    private static long ncr(int n,int r){
        long answer = 1;
        for (int i=0;i<r;i++){
            answer*=(n-i);
            answer/=(i+1);
        }
        return answer;
    }
}
