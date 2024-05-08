package PriorityQueue;

import java.util.*;

public class FindRelativeRanks {
    public static void main(String[] args) {
        int[] score1 = {5, 4, 3, 2, 1};
        int[] score2 = {10, 3, 8, 9, 4};
        System.out.println(Arrays.toString(findRelativeRanks(score1)));
        System.out.println(Arrays.toString(findRelativeRanks(score2)));
        System.out.println(Arrays.toString(findRelativeRanksHashmaps(score1)));
        System.out.println(Arrays.toString(findRelativeRanksHashmaps(score2)));
    }

    private static String[] findRelativeRanks(int[] score) {
        String[] answer = new String[score.length];
        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder(Comparator.comparingInt(a->score[a])));
        for(int i=0;i<score.length;i++){
            pq.add(i);
        }
        int i = 1;
        while (!pq.isEmpty()) {
            int index = pq.remove();
            if (i == 1) {
                answer[index] = "Gold Medal";
            } else if (i == 2) {
                answer[index] = "Silver Medal";
            } else if (i == 3) {
                answer[index] = "Bronze Medal";
            } else {
                answer[index] = String.valueOf(i);
            }
            i++;
        }
        return answer;
    }
    private static String[] findRelativeRanksHashmaps(int[] score){
        String[] answer = new String[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (Integer integer : score) {
            pq.add(integer);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            map.put(score[i], i);
        }
        int pos = 1;
        while (!pq.isEmpty()) {
            int nums = pq.remove();
            int i = map.remove(nums);
            if (pos == 1) {
                answer[i] = "Gold Medal";
            } else if (pos == 2) {
                answer[i] = "Silver Medal";
            } else if (pos == 3) {
                answer[i] = "Bronze Medal";
            } else {
                answer[i] = String.valueOf(pos);
            }
            pos++;
        }
        return answer;
    }
}