package AllLeetCodeContest;

public class LeetCode3242_NeighborSum {
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 2},{3, 4, 5},{6, 7, 8}};
        neighborSum obj = new neighborSum(grid);
        int param_1 = obj.adjacentSum(1);
        int param_2 = obj.diagonalSum(4);
        int param_3 = obj.diagonalSum(4);
        int param_4 = obj.diagonalSum(8);
        System.out.println(param_1);
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }

    public static class neighborSum {
        private final int[][] grid;

        public neighborSum(int[][] grid) {
            this.grid = grid ;
        }

        public int adjacentSum(int value) {
            int[] index = find(this.grid,value);
            if(index==null){
                return 0;
            }
            int sum = 0;
            int i = index[0];
            int j = index[1];
            if(i-1>=0){
                sum+=grid[i-1][j];
            }
            if(i+1<grid.length){
                sum+=grid[i+1][j];
            }
            if(j-1>=0){
                sum+=grid[i][j-1];
            }
            if(j+1<grid.length){
                sum+=grid[i][j+1];
            }
            return sum;
        }
        public int diagonalSum(int value) {
            int[] index = find(this.grid,value);
            if(index==null){
                return 0;
            }
            int sum = 0;
            int i = index[0];
            int j = index[1];
            if(i-1>=0 && j-1>=0){
                sum+=grid[i-1][j-1];
            }
            if(i+1<grid.length && j+1<grid.length ){
                sum+=grid[i+1][j+1];
            }
            if(i-1>=0 && j+1<grid.length){
                sum+=grid[i-1][j+1];
            }
            if(i+1<grid.length &&  j-1>=0){
                sum+=grid[i+1][j-1];
            }
            return sum;
        }
        private int[] find(int[][] grid, int value) {
            for(int i =0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(value==grid[i][j]){
                        return new int[]{i,j};
                    }
                }
            }
            return null;
        }
    }
}
