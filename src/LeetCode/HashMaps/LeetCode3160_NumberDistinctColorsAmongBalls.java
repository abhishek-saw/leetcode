package HashMaps;

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode3160_NumberDistinctColorsAmongBalls {
    public static void main(String[] args) {
        int limit1 = 4;
        int[][] queries1 = {{1,4},{2,5},{1,3},{3,4}};
        int limit2 = 4;
        int[][] queries2 = {{0,1},{1,2},{2,2},{3,4},{4,5}};
        int limit3 = 1;
        int[][] queries3 = {{0,1},{0,4},{1,2},{1,5},{1,4}};
        int limit4 = 1;
        int[][] queries4 = {{0,1},{0,4},{0,4},{0,1},{1,2}};
        System.out.println(Arrays.toString(queryResults(limit1, queries1)));
        System.out.println(Arrays.toString(queryResults(limit2, queries2)));
        System.out.println(Arrays.toString(queryResults(limit3, queries3)));
        System.out.println(Arrays.toString(queryResults(limit4, queries4)));
    }

    private static int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] answer = new int[n];
        int index = 0;
        HashMap<Integer, Integer> ballsMap = new HashMap<>();
        HashMap<Integer, Integer> coloursMap = new HashMap<>();
        for (int[] query : queries) {
            int ball = query[0];
            int colour = query[1];
            if(ballsMap.containsKey(ball)){
                int existingColour = ballsMap.get(ball);
                coloursMap.put(existingColour, coloursMap.get(existingColour)-1);
                if(coloursMap.get(existingColour)==0){
                    coloursMap.remove(colour);
                }
                ballsMap.put(ball,colour);
                coloursMap.put(colour, coloursMap.getOrDefault(colour,0)+1);
            }
            else {
                ballsMap.put(ball,colour);
                coloursMap.put(colour, coloursMap.getOrDefault(colour,0)+1);
            }
            answer[index++] = coloursMap.size();
        }
        return answer;
    }
}
