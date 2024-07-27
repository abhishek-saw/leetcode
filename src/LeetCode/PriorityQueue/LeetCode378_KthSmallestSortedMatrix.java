package PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class LeetCode378_KthSmallestSortedMatrix {
    public static void main(String[] args) {
        int [][] matrix1 = {{1,5,9},{10,11,13},{12,13,15}};
        int k1 = 8;
        int [][] matrix2 = {{-5}};
        int k2 = 1;
        int [][] matrix3 = {{1,2},{1,3}};
        int k3 = 4;
        int [][] matrix4 = {{1,3,5,7,9},{2,4,6,8,10},{11,13,15,17,19},{12,14,16,18,20},{21,22,23,24,25}};
        int k4 = 8;
        System.out.println(kthSmallest(matrix1,k1));
        System.out.println(kthSmallest(matrix2,k2));
        System.out.println(kthSmallest(matrix3,k3));
        System.out.println(kthSmallest(matrix4,k4));
        System.out.println(kthSmallestBinary(matrix1,k1));
        System.out.println(kthSmallestBinary(matrix2,k2));
        System.out.println(kthSmallestBinary(matrix3,k3));
        System.out.println(kthSmallestBinary(matrix4,k4));
    }

    private static int kthSmallestBinary(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length; // For general, the matrix need not be a square
        int left = matrix[0][0];
        int right = matrix[m-1][n-1];
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1; // divide the left and right by 2
            if (countLessOrEqual(matrix,mid,m,n) >= k) {
                ans = mid;
                right = mid - 1; // try to looking for a smaller value in the left side
            } else{
                left = mid + 1; // try to looking for a bigger value in the right side
            }
        }
        return ans;
    }
    static int countLessOrEqual(int[][] matrix, int x,int m,int n) {
        int cnt = 0;
        int c = n - 1; // start with the rightmost column
        for (int r = 0; r < m; ++r) {
            while (c >= 0 && matrix[r][c] > x) {
                --c;  // decrease column until matrix[r][c] <= x
            }
            cnt += (c + 1);
        }
        return cnt;
    }
    private static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = matrix[0].length;
        for (int[] array : matrix) {
            for (int j = 0; j < n; j++) {
                pq.add(array[j]);
                if(pq.size()>k){
                    pq.remove();
                }
            }
        }
        return pq.remove();
    }
}
