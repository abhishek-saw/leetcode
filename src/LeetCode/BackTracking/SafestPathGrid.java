package BackTracking;


import java.util.*;

import static HashMaps.SetZeroes.print;

public class SafestPathGrid {
    static int [][] direction = {{-1,0},{0,-1},{1,0},{0,1}};
    static int maximumSafenessFactor = Integer.MIN_VALUE;
    static int totalSafenessFactor = Integer.MIN_VALUE;
    public static void main(String[] args) {
        List<List<Integer>> grid1 = List.of(
                List.of(0, 0, 1),
                List.of(0, 0, 0),
                List.of(0, 0, 0)
        );
        List<List<Integer>> grid2 = List.of(
                List.of(0, 0, 0,1),
                List.of(0, 0, 0,0),
                List.of(0, 0, 0,0),
                List.of(1, 0, 0,0)
        );
        System.out.println(maximumSafenessFactor(grid1));
        System.out.println(maximumSafenessFactor(grid2));
    }
    private static int maximumSafenessFactor(List<List<Integer>> grid){
        int n = grid.size();
        int[][] distanceNearestThief = new int[n][n];
        for (int[] row : distanceNearestThief) Arrays.fill(row, Integer.MAX_VALUE);
        Queue<int[]> queue = new LinkedList<>();
        // Initialize all thief positions
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid.get(r).get(c) == 1) {
                    queue.offer(new int[]{r, c});
                    distanceNearestThief[r][c] = 0;
                }
            }
        }

        // Multi-source BFS to calculate minimum distanceNearestThief to any thief
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];
            for (int[] dir : direction) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && distanceNearestThief[nr][nc] == Integer.MAX_VALUE) {
                    distanceNearestThief[nr][nc] = distanceNearestThief[r][c] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        // Use priority queue to find path with maximum safeness factor
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.offer(new int[]{distanceNearestThief[0][0], 0, 0});
        int[][] maxSafeness = new int[n][n];
        for (int[] row : maxSafeness) Arrays.fill(row, -1);
        maxSafeness[0][0] = distanceNearestThief[0][0];

        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int d = cell[0], r = cell[1], c = cell[2];
            if (r == n - 1 && c == n - 1) return d;

            for (int[] dir : direction) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    int newSafe = Math.min(d, distanceNearestThief[nr][nc]);
                    if (newSafe > maxSafeness[nr][nc]) {
                        maxSafeness[nr][nc] = newSafe;
                        pq.offer(new int[]{newSafe, nr, nc});
                    }
                }
            }
        }

        return -1;  // In case there's no valid path
    }
    
    public static<T> void printGen(T[][] matrix) {
        for (T[] array : matrix) {
            for (T element : array) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int maximumSafenessFactorOld(List<List<Integer>> grid) {
        int[][] array = new int[grid.size()][];
        for (int i = 0; i < grid.size(); i++) {
            List<Integer> row = grid.get(i);
            array[i] = new int[row.size()];
            for (int j = 0; j < row.size(); j++) {
                array[i][j] = row.get(j);
            }
        }
        if(array[0][0]==1 || array[array.length-1][array[0].length-1]==1){
            return 0;
        }
        int [][] board = new int[array.length][array[0].length];
        findAllPath(array,0,0,board);
        return maximumSafenessFactor == Integer.MIN_VALUE ? 0: maximumSafenessFactor;
    }
    private static void findAllPath(int[][] grid, int i, int j, int[][] board) {
        if(i<0 ||j<0 ||i>grid.length-1 ||j>grid[0].length-1 ||grid[i][j]==1 ||board[i][j]==10){
            return;
        }
        board[i][j] =10;
        if(i== grid.length-1  && j== grid[0].length-1){
            print(board);
            System.out.println();
            findFactor(board,grid);
            System.out.println(maximumSafenessFactor);
            board[i][j] =0;
            return;
        }
        findAllPath(grid,i-1,j,board);
        findAllPath(grid,i,j-1,board);
        findAllPath(grid,i+1,j,board);
        findAllPath(grid,i,j+1,board);
        board[i][j] = 0;
    }
    private static void findFactor(int[][] board, int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int dis = distanceNearestThiefance(i, j, board);
                    if (dis != 0) {
                        maximumSafenessFactor = Math.max(maximumSafenessFactor, dis);
                    }
                }
            }
        }
    }
    private static int distanceNearestThiefance(int i, int j, int[][] board) {
        int answer = Integer.MIN_VALUE;
        int smallAnswer = Integer.MAX_VALUE;
        int sumTotalSafenessFactor = 0;
        for(int m =0;m<board.length;m++) {
            for (int n = 0; n < board[0].length; n++) {
                if (board[m][n] == 10) {
                    int sums = Math.abs(m - i) + Math.abs(n - j);
                    if(sums>1) {
                        smallAnswer = Math.min(sums,smallAnswer);
                        sumTotalSafenessFactor+=sums;
                    }
                }
            }
        }
        if(sumTotalSafenessFactor>totalSafenessFactor){
            totalSafenessFactor = sumTotalSafenessFactor;
            answer = smallAnswer;
        }
        return answer;
    }
}
