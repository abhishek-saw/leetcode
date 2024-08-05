package Array;

import java.util.ArrayList;
import java.util.List;

public class LeetCode54_SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(matrix1));
        System.out.println(spiralOrder(matrix2));
    }

    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int startRow = 0;
        int startCol = 0;
        int endRow = row-1;
        int endCoL = col-1;
        int count = 0;
        int totalCount = row*col;
        while (totalCount>count){
            for(int i =startCol;count<totalCount && i<=endCoL;i++){
                answer.add(matrix[startRow][i]);
                count++;
            }
            startRow++;
            for(int i =startRow;count<totalCount && i<=endRow;i++){
                answer.add(matrix[i][endCoL]);
                count++;
            }
            endCoL--;
            for(int i = endCoL;count<totalCount && i>=startCol;i--){
                answer.add(matrix[endRow][i]);
                count++;
            }
            endRow--;
            for(int i =endRow;count<totalCount && i>=startRow;i--){
                answer.add(matrix[i][startCol]);
                count++;
            }
            startCol++;
        }
        return answer;
    }
}
