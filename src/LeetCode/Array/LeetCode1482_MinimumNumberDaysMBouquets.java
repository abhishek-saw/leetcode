package Array;

import java.util.Arrays;

public class LeetCode1482_MinimumNumberDaysMBouquets {
    public static void main(String[] args) {
        int [] bloomDay1 = {1,10,3,10,2};
        int  m1  = 3;
        int k1 = 1;
        int [] bloomDay2 = {1,10,3,10,2};
        int  m2  = 3;
        int k2 = 2;
        int [] bloomDay3 = {7,7,7,7,12,7,7};
        int  m3  = 2;
        int k3 = 3;
        System.out.println(minDays(bloomDay1,m1,k1));
        System.out.println(minDays(bloomDay2,m2,k2));
        System.out.println(minDays(bloomDay3,m3,k3));
        System.out.println(minDaysBetter(bloomDay1,m1,k1));
        System.out.println(minDaysBetter(bloomDay2,m2,k2));
        System.out.println(minDaysBetter(bloomDay3,m3,k3));
    }

    private static int minDaysBetter(int[] bloomDay, int m, int k) {
        if(bloomDay.length<(long)m*k){
            return -1;
        }
        int start_day = 0;
        int end_day = maxDay(bloomDay);
        int minDays = -1;
        while (start_day<=end_day){
            int mid = start_day + (end_day-start_day)/2;
            if(canMakeBouquets(bloomDay,k,mid)>=m){
                minDays = mid;
                end_day = mid-1;
            }
            else {
                start_day = mid+1;
            }
        }
        return minDays;
    }

    private static int canMakeBouquets(int[] bloomDay, int k, int mid) {
        int bouquetsCount = 0;
        int consecutiveCount = 0;
        for (int j = 0;j<bloomDay.length;j++) {
            if (bloomDay[j] <= mid) {
                consecutiveCount++;
            } else {
                consecutiveCount = 0;
            }
            if (consecutiveCount == k) {
                bouquetsCount++;
                consecutiveCount=0;
            }
        }
        return bouquetsCount;
    }

    private static int maxDay(int[] bloomDay) {
        int max = Integer.MIN_VALUE;
        for(int i :bloomDay){
            max = Math.max(max,i);
        }
        return max;
    }

    private static int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int low = 1, high = (int) 1e9;
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (isPossibleBouquets(bloomDay, m, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        };

        return low;
    }
    private static boolean isPossibleBouquets(int[] bloomDay, int m, int k, int day) {
        int total = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            int count = 0;
            while (i < bloomDay.length && count < k && bloomDay[i] <= day) {
                count++;
                i++;
            }

            if (count == k) {
                total++;
                i--;
            }

            if (total >= m) {
                return true;
            }
        }

        return false;
    }

}