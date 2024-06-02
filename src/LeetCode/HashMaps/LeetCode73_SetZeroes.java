package HashMaps;

import java.util.HashMap;


public class LeetCode73_SetZeroes {
    public static void main(String[] args) {
        int [][] matrix = {{1,1,2,3},{3,1,5,2},{1,3,1,0}};
        print(matrix);
        System.out.println();
//        setZeroes(matrix);
        setZeroesBetter(matrix);
        print(matrix);
    }

    private static void setZeroes(int[][] matrix) {
        HashMap<Integer,Boolean> rowMap = new HashMap<>();
        HashMap<Integer,Boolean> colMap = new HashMap<>();
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                    rowMap.put(i,true);
                    colMap.put(j,true);
                }
            }
        }
        System.out.println(rowMap);
        System.out.println(colMap);
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[i].length;j++){
                if(rowMap.containsKey(i)){
                    matrix[i][j]=0;
                }
                if(colMap.containsKey(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }
    public static void print(int[][] matrix) {
        for (int[] array : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(array[j] + " ");
            }
            System.out.println();
        }
    }
    private static void setZeroesBetter(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        boolean rowZero = false;
        for(int i = 0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    if (i > 0) {
                        matrix[i][0] = 0;
                    }
                    else{
                        rowZero=true;
                    }
                }
            }
        }
        for(int i = 1;i<m;i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 ||matrix[0][j]==0) {
                    matrix[i][j]=0;
                }
            }
        }
        if(matrix[0][0]==0){
            for(int i = 0;i<m;i++) {
                matrix[i][0] = 0;
            }
        }
        if(rowZero){
            for (int j = 0; j < n; j++) {
                matrix[0][j]=0;
            }
        }
    }
}
