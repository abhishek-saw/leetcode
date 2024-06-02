package Array;


public class LeetCode48_RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        print(matrix);
        rotate(matrix);
        System.out.println();
        print(matrix);
    }

    private static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int[] array : matrix) {
            reverse(array, n);
        }
        int row = n-1;
        int col = n-1;
        for(int i =0;i<n;i++){
            for(int j =0;j<n-i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[row][col];
                matrix[row][col] = temp;
                row--;
            }
            col--;
            row = n-1;
        }
    }

    private static void reverse(int[] array,int n) {
        int start = 0;
        int end = n-1;
        while (start<=end){
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
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
}
