package Array;

import java.lang.reflect.Array;

import static Array.LeetCode48_RotateImage.print;

public class LeetCode1568_MinimumNumberDaysDisconnectIsland {
    public static void main(String[] args) {
       int[][] grid1 = {{0,1,1,0},{0,1,1,0},{0,0,0,0}};
        int[][] grid2 = {{1,1}};
        int[][] grid3 = {{1,1,0,1,1},{1,1,1,1,1},{1,1,0,1,1},{1,1,0,1,1}};
        System.out.println(minDays(grid1));
        System.out.println(minDays(grid2));
        System.out.println(minDays(grid3));
    }

    private static int minDays(int[][] grid) {
        int island = findNumberOfIslands(grid);
        if (island > 1 || island == 0) {
            return 0;
        } else {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        grid[i][j] = 0;
                        island = findNumberOfIslands(grid);
                        if (island > 1 || island == 0) {
                            return 1;
                        }
                        grid[i][j] = 1;
                    }
                }
            }
        }
        return 2;
    }

    private static int findNumberOfIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] originalGrid = new int[m][n];
        for (int i = 0; i < grid.length; i++) {
            System.arraycopy(grid[i], 0, originalGrid[i], 0, n);
        }
        int findNumberOfIslands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (originalGrid[i][j] == 1 ) {
                    dfs(originalGrid, i, j);
                    findNumberOfIslands += 1;
                }
            }
        }
        return findNumberOfIslands;
    }

    private static void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 | j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
