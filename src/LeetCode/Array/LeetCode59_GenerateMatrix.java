package Array;

import java.util.Arrays;

public class LeetCode59_GenerateMatrix {
    public static void main(String[] args) {
        int n1 = 1;
        int n2 = 2;
        int n3 = 3;
        int n4 = 4;
        System.out.println(Arrays.deepToString(generateMatrix(n1)));
        System.out.println(Arrays.deepToString(generateMatrix(n2)));
        System.out.println(Arrays.deepToString(generateMatrix(n3)));
        System.out.println(Arrays.deepToString(generateMatrix(n4)));
    }

    private static int[][] generateMatrix(int n) {
        int [][] matrix = new int[n][n];
        int startRow = 0;
        int startCol = 0;
        int endRow = n-1;
        int endCoL = n-1;
        int count = 1;
        int totalCount = n*n;
        while (totalCount>=count){
            for(int i =startCol;count<=totalCount && i<=endCoL;i++){
                matrix[startRow][i] = count++;
            }
            startRow++;
            for(int i =startRow;count<=totalCount && i<=endRow;i++){
                matrix[i][endCoL] = count++;
            }
            endCoL--;
            for(int i = endCoL;count<=totalCount && i>=startCol;i--){
               matrix[endRow][i] = count++;
            }
            endRow--;
            for(int i =endRow;count<=totalCount && i>=startRow;i--){
                matrix[i][startCol] = count++;
            }
            startCol++;
        }
        return matrix;
    }
}
