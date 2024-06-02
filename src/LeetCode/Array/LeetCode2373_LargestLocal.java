package Array;


import static Array.LeetCode48_RotateImage.print;

public class LeetCode2373_LargestLocal {
    public static void main(String[] args) {
        int[][] grid1 = {{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}};
        int[][] grid2 = {{1,1,1,1,1},{1,1,1,1,1},{1,1,2,1,1},{1,1,1,1,1},{1,1,1,1,1}};
        print(largestLocal(grid1));
        System.out.println();
        print(largestLocal(grid2));
    }
    private static int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int [][] maxLocal = new int[n-2][n-2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                maxLocal[i][j] = getMax(grid, i, j);
            }
        }
        return maxLocal;
    }

    private static int getMax(int[][] grid, int i, int j) {
        int max = 0;
        for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++) {
                max = Math.max(max, grid[k][l]);
            }
        }
        return max;
    }
}
