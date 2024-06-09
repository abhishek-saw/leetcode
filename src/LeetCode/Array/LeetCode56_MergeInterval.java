package Array;

import java.util.*;

public class LeetCode56_MergeInterval {
    public static void main(String[] args) {
        int [][] intervals1 = {{1,3},{2,6},{8,10},{15,18}};
        int [][] intervals2 = {{1,4},{4,5}};
        int [][] intervals3 = {{1,4},{2,3}};
        int [][] intervals4 = {{1,4},{0,2},{3,5}};
        int [][] intervals5 = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        int [][] intervals6 = {{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}};
        System.out.println(Arrays.deepToString(merge(intervals1)));
        System.out.println(Arrays.deepToString(merge(intervals2)));
        System.out.println(Arrays.deepToString(merge(intervals3)));
        System.out.println(Arrays.deepToString(merge(intervals4)));
        System.out.println(Arrays.deepToString(merge(intervals5)));
        System.out.println(Arrays.deepToString(merge(intervals6)));

    }

    private static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> answer = new ArrayList<>();
        answer.add(intervals[0]);
        int prevFirst = intervals[0][0];
        int prevSecond = intervals[0][1];
        for (int[] interval : intervals) {
            int currFirst = interval[0];
            int currSecond = interval[1];
            if (currFirst <= prevSecond) {
                answer.remove(answer.size() - 1);
                prevFirst = Math.min(currFirst, prevFirst);
                prevSecond = Math.max(currSecond, prevSecond);
                answer.add(new int[]{prevFirst, prevSecond});
            } else {
                answer.add(new int[]{currFirst, currSecond});
                prevFirst = currFirst;
                prevSecond = currSecond;
            }
        }
        return answer.toArray(new int[0][]);
    }
}
