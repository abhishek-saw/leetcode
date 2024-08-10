package Array;

import static Array.LeetCode48_RotateImage.print;

public class LeetCode959_RegionsBySlashes {
    public static void main(String[] args) {
        String[] grid1 = {" /","/ "};
        String[] grid2 = {" /","  "};
        String[] grid3 = {"/\\","\\/"};
        System.out.println(regionsBySlashes(grid1));
        System.out.println(regionsBySlashes(grid2));
        System.out.println(regionsBySlashes(grid3));
    }
    private static int regionsBySlashes(String[] grid){
        int row = grid.length;
        int col = grid[0].length();
        int[][] matrix = new int[3 * row][3 * col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i].charAt(j) == '/') {
                    matrix[3 * i][3 * j + 2] = 1;
                    matrix[3 * i + 1][3 * j + 1] = 1;
                    matrix[3 * i + 2][3 * j] = 1;
                } else if (grid[i].charAt(j) == '\\') {
                    matrix[3 * i][3 * j] = 1;
                    matrix[3 * i + 1][3 * j + 1] = 1;
                    matrix[3 * i + 2][3 * j + 2] = 1;
                }
            }
        }
        int region = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    region += dfs(matrix, i, j) > 0 ? 1 : 0;
                }
            }
        }
        return region;
    }

    private static int dfs(int[][] matrix, int i, int j) {
        if (Math.min(i, j) < 0 || Math.max(i, j) >= matrix.length || matrix[i][j] == 1) {
            return 0;
        }
        matrix[i][j] = 1;
        return 1 + dfs(matrix, i + 1, j) + dfs(matrix, i - 1, j) + dfs(matrix, i, j + 1) + dfs(matrix, i, j - 1);
    }
}