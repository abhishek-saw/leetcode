package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode1380_LuckyNumbersMatrix {
    public static void main(String[] args) {
        int[][] matrix1 = {{3,7,8},{9,11,13},{15,16,17}};
        System.out.println(luckyNumbers(matrix1));
        int[][] matrix2 = {{1,10,4,2},{9,3,8,7},{15,16,17,12}};
        System.out.println(luckyNumbers(matrix2));
        int[][] matrix3 = {{7,8},{1,2}};
        System.out.println(luckyNumbers(matrix3));
    }

    private static List<Integer> luckyNumbers(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] rowMin = new int[row];
        int[] colMin = new int[col];
        for(int i = 0;i<row;i++){
            int data =  Integer.MAX_VALUE;
            for(int j = 0;j<col;j++){
                data = Math.min(data,matrix[i][j]);
            }
            rowMin[i] = data;
        }
        for(int i = 0;i<col;i++){
            int data =  Integer.MIN_VALUE;
            for(int j = 0;j<row;j++){
                data = Math.max(data,matrix[j][i]);
            }
            colMin[i] = data;
        }
        System.out.println(Arrays.toString(colMin));
        System.out.println(Arrays.toString(rowMin));
        List<Integer> luckyNumbers = new ArrayList<>();
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(matrix[i][j]<=rowMin[i] && matrix[i][j]>=colMin[j]){
                    luckyNumbers.add(matrix[i][j]);
                }
            }
        }
        return luckyNumbers;
    }
}
