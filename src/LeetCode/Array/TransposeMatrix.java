package Array;

import java.util.Arrays;

public class TransposeMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        print(matrix);
        int[][] tMatrix = transpose(matrix);
        System.out.println();
        print(tMatrix);
    }

    private static void print(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] transpose(int[][] matrix) {
        int[][] tMatrix = new  int [matrix[0].length][matrix.length];
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                tMatrix[j][i] = matrix[i][j];
            }
        }
        return tMatrix;
    }
}

