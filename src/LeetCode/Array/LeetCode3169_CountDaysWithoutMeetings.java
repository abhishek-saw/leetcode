package Array;

import java.util.*;

public class LeetCode3169_CountDaysWithoutMeetings {
    public static void main(String[]args) {
        int days1 = 10;
        int [][] meetings1 = {{5,7},{1,3},{9,10}};
        int days2 = 5;
        int [][] meetings2 = {{2,4},{1,3}};
        int days3 = 6;
        int [][] meetings3 = {{1,6}};
        int days4 = 8;
        int[][] meetings4 = {{3,4},{4,8},{2,5},{3,8}};
        int days5 = 8;
        int[][] meetings5 = {{2,3},{3,5},{8,8}};
        System.out.println(countDays(days1,meetings1));
        System.out.println(countDays(days2,meetings2));
        System.out.println(countDays(days3,meetings3));
        System.out.println(countDays(days4,meetings4));
        System.out.println(countDays(days5,meetings5));
    }

    private static int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a->a[0]));
        int prevStart = meetings[0][0];
        int prevEnd = meetings[0][1];
        List<int[]> merged = new ArrayList<>();
        merged.add(new int[]{prevStart,prevEnd});
        for(int i =1;i<meetings.length;i++){
            int currStart = meetings[i][0];
            int currEnd = meetings[i][1];
            if(currStart<=prevEnd){
                merged.remove(merged.size()-1);
                prevStart = Math.min(prevStart,currStart);
                prevEnd =  Math.max(prevEnd,currEnd);
                merged.add(new int[]{prevStart,prevEnd});
            }
            else {
                merged.add(new int[]{currStart,currEnd});
                prevStart = currStart;
                prevEnd = currEnd;
            }
        }
        int count = 0;
        for (int[] array : merged) {
            count += (array[1] - array[0] + 1);
        }
        return days-count;
    }
}
