package Array;

public class CountNegatives {
    public static void main(String[] args) {
//        int [][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
//        int [][] grid = {{5,1,0},{-5,-5,-5}};
        int [][] grid = {{3,2},{-3,-3},{-3,-3},{-3,-3}};
        System.out.println(countNegatives(grid));
    }

    private static int countNegatives(int[][] grid) {
        int count = 0;
        int row = 0;
        int col = grid[0].length-1;
        while(row<grid.length){
            if(col>=0 && grid[row][col]<0){
                count++;
                col--;
            }
            else{
                row++;
                col= grid[0].length-1;
            }
        }
        return count;
    }
}
