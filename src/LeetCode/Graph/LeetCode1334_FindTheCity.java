package Graph;

import java.util.Arrays;

public class LeetCode1334_FindTheCity {
    public static void main(String[] args) {
        int n1 = 4;
        int[][] edges1 = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        int distanceThreshold1 = 4;
        int n2 = 5;
        int[][] edges2 = {{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}};
        int distanceThreshold2 = 2;
        System.out.println(findTheCity(n1,edges1,distanceThreshold1));
        System.out.println(findTheCity(n2,edges2,distanceThreshold2));
    }

    private static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], 1000000000);
            distance[i][i] = 0;
        }

        for (int[] edge : edges) {
            distance[edge[0]][edge[1]] = edge[2];
            distance[edge[1]][edge[0]] = edge[2];
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        int ans = -1;
        int mini = Integer.MAX_VALUE;
        int[] reachable = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && distance[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            reachable[i] = count;
            if (count <= mini) {
                mini = count;
                ans = i;
            }
        }

        return ans;
    }
}
