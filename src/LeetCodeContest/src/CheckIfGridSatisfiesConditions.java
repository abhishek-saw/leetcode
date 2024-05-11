public class CheckIfGridSatisfiesConditions {
//    You are given a 2D matrix grid of size m x n. You need to check if each cell grid[i][j] is:
//    Equal to the cell below it, i.e. grid[i][j] == grid[i + 1][j] (if it exists).
//    Different from the cell to its right, i.e. grid[i][j] != grid[i][j + 1] (if it exists).
//    Return true if all the cells satisfy these conditions, otherwise, return false.
    public static void main(String[] args) {
        int [][] grid1 = {{1,0,2},{1,0,2},{1,0,2}};
        int [][] grid2 = {{1,1,1},{0,0,0}};
        int [][] grid3 = {{1},{2},{3}};
        int [][] grid4 = {{1,7},{1,1}};
        System.out.println(satisfiesConditions(grid1));
        System.out.println(satisfiesConditions(grid2));
        System.out.println(satisfiesConditions(grid3));
        System.out.println(satisfiesConditions(grid4));
    }
    public static boolean satisfiesConditions(int[][] grid) {
        if(grid.length==0){
            return true;
        }
        int m = grid.length;
        int n = grid[0].length;
        boolean answer = true;
        if(m==1 && n==1){
            return true;
        }
        if(m>1 && n==1){
            for(int i = 0;i<m-1;i++){
                for(int j = i+1;j<i+2;j++){
                    if (grid[i][0] != grid[j][0]) {
                        answer = false;
                        break;
                    }
                }
            }
        }
        else {
            for (int i = 0; i < m-1; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] != grid[i + 1][j]) {
                        return false;
                    }
                }
            }
            for (int j = 0; j < n-1; j++) {
                for (int i = 0; i < m; i++) {
                    if (grid[i][j] == grid[i][j+1]) {
                        return false;
                    }
                }
            }

        }
        return answer;
    }
}
