package DynamicProgramming;

import java.util.Arrays;

public class MinimumPathSum {
    public static void main(String[] args) {
        int [][] grid1 = {{1,3,1},{1,5,1},{4,2,1}};
        int [][] grid2 = {{1,2,3},{4,5,6}};
        System.out.println(minPathSumBetter(grid1));
        System.out.println(minPathSumBetter(grid2));
        System.out.println(minPathSum(grid1));
        System.out.println(minPathSum(grid2));
    }

    private static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length+1][grid[0].length+1];
        for(int [] array : dp){
            Arrays.fill(array,0);
        }
        return minPathSumHelper(grid,0,0,dp);
    }

    private static int minPathSumHelper(int[][] grid, int i, int j, int[][] dp) {
        if(i==grid.length-1 && j==grid[0].length-1){
            return grid[i][j];
        }
        if(i>=grid.length||j>=grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }

        int a  = minPathSumHelper(grid,i+1,j, dp);
        int b  = minPathSumHelper(grid,i,j+1, dp);
        dp[i][j] = grid[i][j] + Math.min(a,b);
        return dp[i][j];
    }
    private static int minPathSumBetter(int[][] grid) {
        int[][] dp = new int[grid.length+1][grid[0].length+1];
        for(int [] array : dp){
            Arrays.fill(array,Integer.MAX_VALUE);
        }
        for(int i = 1;i<dp.length;i++){
            for(int j = 1;j<dp[i].length;j++){
                if(i==1 && j==1){
                    dp[i][j] = grid[0][0];
                    continue;
                }
                int a  = dp[i-1][j];
                int b  = dp[i][j-1];
                dp[i][j] = grid[i-1][j-1] + Math.min(a,b);
            }
        }
        return dp[grid.length][grid[0].length];
    }
}
