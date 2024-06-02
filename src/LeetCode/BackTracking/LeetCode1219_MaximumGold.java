package BackTracking;


import static HashMaps.LeetCode73_SetZeroes.print;

public class LeetCode1219_MaximumGold {
    static int [] dx = {-1,0,0,1};
    static int [] dy = {0,-1,1,0};

    public static void main(String[] args) {
        //Time Complexity : (m*n)*4^(m+n)
        //Space Complexity : 4*(m+n)
        // m+n = count of cells having gold possibilities <=25
        int[][] grid1 = {{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        int[][] grid2 = {{1, 0, 7}, {2, 0, 6}, {3, 4, 5}, {0, 3, 0}, {9, 0, 20}};
        print(grid1);
        System.out.println("Maximum Gold: " + getMaximumGold(grid1));
        print(grid2);
        System.out.println("Maximum Gold: " + getMaximumGold(grid2));
    }

    private static int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxGold = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    maxGold = Math.max(maxGold, maximumGoldDFS(grid, i, j));
                }
            }
        }
        return maxGold;
    }
    private static int maximumGoldDFS(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i > grid.length-1 || j > grid[0].length-1 || grid[i][j] == 0) {
            return 0;
        }
        int maxGold = 0;
        for(int d =0;d<4;d++){
            int originalGold = grid[i][j];
            grid[i][j] = 0;
            int ni = i + dx[d];
            int nj = j + dy[d];
            maxGold = Math.max(maxGold,originalGold+maximumGoldDFS(grid, ni,nj));
            grid[i][j] = originalGold;
        }
        return maxGold;
    }
    private static int maximumGoldDFSWithoutLoop(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i > grid.length-1 || j > grid[0].length-1 || grid[i][j] == 0) {
            return 0;
        }
        int maxGold = 0;
        int originalGold = grid[i][j];
        grid[i][j] = 0;
//         4^(m+n) directions
        maxGold = Math.max(maxGold,maximumGoldDFSWithoutLoop(grid, i - 1, j));
        maxGold = Math.max(maxGold,maximumGoldDFSWithoutLoop(grid, i + 1, j));
        maxGold = Math.max(maxGold,maximumGoldDFSWithoutLoop(grid, i, j - 1));
        maxGold = Math.max(maxGold,maximumGoldDFSWithoutLoop(grid, i, j + 1));
        grid[i][j] = originalGold;
        return originalGold+maxGold;
    }
}