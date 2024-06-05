package BackTracking;

import static Array.LeetCode48_RotateImage.print;

public class LeetCode52_NQueenII {
    static int totalNQueen =0;
    public static void main(String[] args) {
        int n = 4;
        System.out.println(totalNQueens(n));
    }

    private static int totalNQueens(int n) {
        int[][] board = new int[n][n];
        backTracking(board, n, 0);
        return totalNQueen;
    }
    private static boolean backTracking(int[][] board,int n, int row) {
        if(row==n){
            print(board);
            System.out.println();
            totalNQueen++;
            return true;
        }
        boolean placed = false;
        for(int i = 0;i<n;i++){
            if(isSafe(board,row,i,n)){
                board[row][i]=1;
                placed = backTracking(board,n, row+1) || placed;
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
}
