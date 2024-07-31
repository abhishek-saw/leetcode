package DynamicProgramming;

import java.util.Arrays;

public class LeetCode1105_MinHeightShelves {
    static int width;
    public static void main(String[] args) {
        int[][] books1 = {{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}};
        int shelfWidth1 = 4;
        int[][] books2 = {{1,3},{2,4},{3,2}};
        int shelfWidth2 = 6;
        System.out.println(minHeightShelves(books1,shelfWidth1));
        System.out.println(minHeightShelves(books2,shelfWidth2));
    }

    private static int minHeightShelves(int[][] books, int shelfWidth) {
        width = shelfWidth;
        int[][] dp = new int[1001][1001];
        for(int [] array : dp){
            Arrays.fill(array,-1);
        }
        return recursion(books,0, shelfWidth,0,dp);
    }

    private static int recursion(int[][] books, int idx, int remainingShelfWidth, int maxH, int[][] dp) {
        if (idx >= books.length) {
            return maxH;
        }
        if(dp[idx][remainingShelfWidth]!=-1){
            return dp[idx][remainingShelfWidth];
        }
        int bookW = books[idx][0];
        int bookH = books[idx][1];
        int keep = Integer.MAX_VALUE;
        int skip = Integer.MAX_VALUE;
        if (bookW <= remainingShelfWidth) {
            keep = recursion(books, idx + 1, remainingShelfWidth-bookW,Math.max(maxH,bookH), dp);
        }
        skip = maxH+ recursion(books, idx + 1, width-bookW,bookH, dp);
        dp[idx][remainingShelfWidth] = Math.min(keep, skip);
        return dp[idx][remainingShelfWidth];
    }
}
