package Array;

import java.util.Arrays;

public class LeetCode885_SpiralMatrixIII {
    public static void main(String[] args) {
        int rows1 = 1, cols1 = 4, rStart1 = 0, cStart1 = 0;
        int rows2 = 5, cols2 = 6, rStart2 = 1, cStart2 = 4;
        System.out.println(Arrays.deepToString(spiralMatrixIII(rows1, cols1, rStart1, cStart1)));
        System.out.println(Arrays.deepToString(spiralMatrixIII(rows2, cols2, rStart2, cStart2)));
    }
    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int totalCount = rows*cols;
        int[][] matrix = new int[totalCount][2];
        int count = 0;
        int steps = 0;
        int dir = 0;
        matrix[count++] =  new int []{rStart,cStart};
        int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
        while (count<totalCount){
            //EAST && //SOUTH
            if(dir==0 || dir==2) {
                steps++;
            }
            for (int i  = 0; i < steps; i++) {
                rStart += direction[dir][0];
                cStart += direction[dir][1];
                if (rStart>=0 && rStart<rows && cStart>=0 && cStart < cols) {
                    matrix[count++] = new int[]{rStart, cStart};
                }
            }
            // WEST && NORTH
            for (int i  = 0; i < steps; i++) {
                rStart += direction[dir][0];
                cStart += direction[dir][1];
                if (rStart>=0 && rStart<rows && cStart>=0 && cStart < cols) {
                    matrix[count++] = new int[]{rStart, cStart};
                }
            }
            dir = (dir+1)%4;
        }
        return matrix;

    }
}
