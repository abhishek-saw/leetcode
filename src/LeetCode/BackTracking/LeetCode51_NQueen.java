package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class LeetCode51_NQueen {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(totalNQueens(n));
    }

    private static List<List<String>> totalNQueens(int n) {
        int[][] board = new int[n][n];
        List<List<String>> answer = new ArrayList<>();
        backTracking(board, n, 0,answer);
        return answer;
    }

    private static boolean backTracking(int[][] board,int n, int row,List<List<String>> answer) {
        if(row==n){
            List<String> currList = construct(board);
            answer.add(new ArrayList<>(currList));
            return true;
        }
        boolean placed = false;
        for(int i = 0;i<n;i++){
            if(isSafe(board,row,i,n)){
                board[row][i]=1;
                placed = backTracking(board,n, row+1,answer)||placed;
                board[row][i]=0;
            }
        }
        return placed;
    }
    private static boolean isSafe(int[][] board, int row, int col,int n) {
        for(int i = 0;i<n;i++){
            if(board[row][i]==1){
                return false;
            }
        }
        for(int i = 0;i<n;i++){
            if(board[i][col]==1){
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1)
                return false;
        }


        return true;
    }
    private static List<String> construct(int[][] board) {
        List<String> currList = new ArrayList<>();
        for (int[] array : board) {
            StringBuilder s = new StringBuilder();
            for (int nums : array) {
                if (nums == 1) {
                    s.append("Q");
                } else {
                    s.append(".");
                }
            }
            currList.add(s.toString());
        }
        return currList;
    }
}
