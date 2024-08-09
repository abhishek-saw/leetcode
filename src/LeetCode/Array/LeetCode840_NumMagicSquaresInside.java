package Array;

public class LeetCode840_NumMagicSquaresInside {
    public static void main(String[] args) {
        int[][] grid1 = {{4,3,8,4},{9,5,1,9},{2,7,6,2}};
        int[][] grid2 = {{8}};
        int[][] grid3 = {{10,3,5},{1,6,11},{7,9,2}};
        int[][] grid4 = {{7,0,5},{2,4,6},{3,8,1}};
        int[][] grid5 = {{5,5,5},{5,5,5},{5,5,5}};
        int[][] grid6 = {{3,10,2,3,4},{4,5,6,8,1},{8,8,1,6,8},{1,3,5,7,1},{9,4,9,2,9}};
//        System.out.println(numMagicSquaresInside(grid1));
//        System.out.println(numMagicSquaresInside(grid2));
//        System.out.println(numMagicSquaresInside(grid3));
//        System.out.println(numMagicSquaresInside(grid4));
//        System.out.println(numMagicSquaresInside(grid5));
        System.out.println(numMagicSquaresInside(grid6));
    }

    private static int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        if(grid==null||grid.length<3 || grid[0].length==0){
            return count;
        }
        int m = grid.length;
        int n = grid[0].length;
       
        for(int i =0;i<m-2;i++){
            for (int j =0;j<n-2;j++){
                boolean flag = true;
                if(grid[i][j]==grid[i][j+1]){
                    flag = false;
                }
                if(grid[i][j]<1|| grid[i][j]>9 ){
                    flag = false;
                }
                if(grid[i][j+1]<1|| grid[i][j+1]>9){
                    flag = false;
                }
                if(grid[i][j+2]<1|| grid[i][j+2]>9){
                    flag = false;
                }

                if(grid[i+1][j]<1|| grid[i+1][j]>9 ){
                    flag = false;
                }
                if(grid[i+1][j+1]<1|| grid[i+1][j+1]>9){
                    flag = false;
                }
                if(grid[i+1][j+2]<1|| grid[i+1][j+2]>9){
                    flag = false;
                }
                if(grid[i+2][j]<1|| grid[i][j]>9 ){
                    flag = false;
                }
                if(grid[i+2][j+1]<1|| grid[i+2][j+1]>9){
                    flag = false;
                }
                if(grid[i+2][j+2]<1|| grid[i+2][j+2]>9){
                    flag = false;
                }
                int row1 = grid[i][j] + grid[i][j+1] + grid[i][j+2];
                int row2 = grid[i+1][j] + grid[i+1][j+1] + grid[i+1][j+2];
                int row3 = grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2];
                int col1 = grid[i][j] + grid[i+1][j] + grid[i+2][j];
                int col2 = grid[i][j+1] + grid[i+1][j+1] + grid[i+2][j+1];
                int col3 = grid[i][j+2] + grid[i+1][j+2] + grid[i+2][j+2];
                int dia1 = grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2];
                int dia2 = grid[i][j+2] + grid[i+1][j+1] + grid[i+2][j];
                if(row1!=row2 || row2!=row3){
                    flag = false;
                }
                if(col1!=col2 || col2!=col3){
                    flag = false;
                }
                if (row1!=col1 || col1!=dia1 || dia1!=dia2){
                    flag = false;
                }
                if(flag){
                count++;
                }
            }
        }
        return count;
    }
}
