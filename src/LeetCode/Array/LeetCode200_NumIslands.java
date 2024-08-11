package Array;

public class LeetCode200_NumIslands {
    public static void main(String[] args) {
        char[][] grid1 = {{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};
        char[][] grid2 = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(numIslands(grid1));
        System.out.println(numIslands(grid2));
    }

    private static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                islands += dfs(grid, i, j) > 0 ? 1 : 0;
            }
        }
        return islands;
    }

    private static int dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 | j >= grid[0].length || grid[i][j] == '0') {
            return 0;
        }
        grid[i][j] = '0';
        return 1 + dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j + 1) + dfs(grid, i, j - 1);
    }
}
