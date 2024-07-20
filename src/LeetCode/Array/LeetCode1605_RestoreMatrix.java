package Array;

import java.util.Arrays;

public class LeetCode1605_RestoreMatrix {
    public static void main(String[] args) {
        int [] rowSum1 = {3,8};
        int [] colSum1 = {4,7};
        int [] rowSum2 = {5,7,10};
        int [] colSum2 = {8,6,8};
        int [] rowSum3 = {14,9};
        int [] colSum3 = {6,9,8};
        System.out.println(Arrays.deepToString(restoreMatrix(rowSum1, colSum1)));
        System.out.println(Arrays.deepToString(restoreMatrix(rowSum2, colSum2)));
        System.out.println(Arrays.deepToString(restoreMatrix(rowSum3, colSum3)));
        int [] rowSum11 = {3,8};
        int [] colSum11 = {4,7};
        int [] rowSum22 = {5,7,10};
        int [] colSum22 = {8,6,8};
        int [] rowSum33 = {14,9};
        int [] colSum33 = {6,9,8};
        System.out.println(Arrays.deepToString(restoreMatrixBetter(rowSum11, colSum11)));
        System.out.println(Arrays.deepToString(restoreMatrixBetter(rowSum22, colSum22)));
        System.out.println(Arrays.deepToString(restoreMatrixBetter(rowSum33, colSum33)));
    }

    private static int[][] restoreMatrixBetter(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int [][] matrix = new int[m][n];
        int i = 0;
        int j = 0;
        while (i<m && j<n){
            matrix[i][j]= Math.min(rowSum[i],colSum[j]);
            rowSum[i]-=matrix[i][j];
            colSum[j]-=matrix[i][j];
            if(rowSum[i]==0){
                i++;
            }
            else {
                j++;
            }
        }
        return matrix;
    }

    private static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int [][] matrix = new int[rowSum.length][colSum.length];
        for(int i =0;i<rowSum.length;i++){
            for(int j = 0;j< colSum.length;j++){
                int min = Math.min(rowSum[i],colSum[j]);
                matrix[i][j]=min;
                rowSum[i]-=min;
                colSum[j]-=min;
            }
        }
        return matrix;
    }
}
