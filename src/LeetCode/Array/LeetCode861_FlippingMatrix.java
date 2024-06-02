package Array;


import static Array.LeetCode48_RotateImage.print;

public class LeetCode861_FlippingMatrix {
    public static void main(String[] args) {
        int [][] grid = {{0,0,1,1,1},{1,0,1,0,1},{1,1,0,0,1}};
        print(grid);
        System.out.println(matrixScore(grid));
    }
    private static int matrixScore(int[][] grid) {
        for(int i = 0;i<grid.length;i++){
            flipRow(grid, i);
        }
        print(grid);
        for(int j=0;j<grid[0].length;j++){
            flipCol(grid, j);
        }
        print(grid);
        return  getScore(grid);
    }

    private static void flipRow(int[][] grid, int i) {
        if(grid[i][0]==0){
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j]^=1;
            }
        }
    }
    private static void flipCol(int[][] grid, int j) {
        int count = 0;
        for (int[] array : grid) {
            if (array[j] == 0) {
                count++;
            }
        }
        if(count>(double) grid.length/2){
            for(int m = 0; m< grid.length; m++){
                grid[m][j]^=1;
            }
        }
    }
    private static int getScore(int[][] grid) {
        int score = 0;
        for (int[] array : grid) {
            int decimal = 0;
            for (int j = grid[0].length - 1; j >= 0; j--) {
                decimal += (int) (array[j] * Math.pow(2, grid[0].length - j - 1));
            }
            System.out.println(decimal);
            score += decimal;
        }
        return score;
    }
}
