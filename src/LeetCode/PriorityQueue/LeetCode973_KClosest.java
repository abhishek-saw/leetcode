package PriorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode973_KClosest {
    public static void main(String[] args) {
        int [][] points  = {{3,3},{5,-1},{-2,4}};
        int k = 2;
        System.out.println(Arrays.deepToString(kClosest(points, k)));
        System.out.println(Arrays.deepToString(kClosestBetter(points, k)));

    }
    private static int[][] kClosest(int[][] points, int k) {
        int[][] answer = new  int[k][2];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
                Comparator.comparingInt(a -> (a[0] * a[0] + a[1] * a[1])));
        priorityQueue.addAll(Arrays.asList(points));
        int count = 0;
        while (k-->0){
            answer[count++] = priorityQueue.poll();
        }
        return answer;
    }

    private static int[][] kClosestBetter(int[][] points, int k){
        int n = points.length;
        int low = 0;
        int high = n - 1;
        int pivot = n;

        while (pivot != k) {
            pivot = partition(points, low, high);
            if (pivot > k) {
                high = pivot - 1;
            } else {
                low = pivot;
            }
        }
        System.out.println(Arrays.deepToString(points));;
        return Arrays.copyOf(points, k);
    }

    public static int partition(int[][] points, int low, int high) {
        int pivot = low + (high - low) / 2;
        int pivotDistEstimate = distEstimate(points[pivot]);

        while (low < high) {
            if (distEstimate(points[low]) >= pivotDistEstimate) {
                swap(points, low, high);
                high--;
            } else {
                low++;
            }
        }
        if (distEstimate(points[low]) < pivotDistEstimate) {
            low++;
        }
        return low;
    }

    public static void swap(int[][] points, int x, int y) {
        int[] temp = points[x];
        points[x] = points[y];
        points[y] = temp;
    }

    public static int distEstimate(int[] point) {
        return point[0]*point[0] + point[1]*point[1];
    }
}
