package Graph;

import java.util.Arrays;

public class LeetCode2285_MaximumImportance {
    public static void main(String[] args) {
        int n = 5;
        int [][] roads = {{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}};
        System.out.println(maximumImportance(n,roads));
    }

    private static long maximumImportance(int n, int[][] roads) {
        long[] degree = new long[n];

        for (int[] edge : roads) {
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        Arrays.sort(degree);

        long value = 1;
        long totalImportance = 0;
        for (long d : degree) {
            totalImportance += (value * d);
            value++;
        }

        return totalImportance;
    }
}