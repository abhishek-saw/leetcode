package Array;

import java.util.Arrays;

public class LeetCode1552_MagneticForceBetweenTwoBalls {
    public static void main(String[] args) {
        int [] position1 = {1,2,3,4,7};
        int m1 = 3;
        int [] position2 = {5,4,3,2,1,1000000000};
        int m2 = 2;
        System.out.println(maxDistance(position1,m1));
        System.out.println(maxDistance(position2,m2));
    }

    private static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int start = 1;
        int end = (position[position.length-1]-position[0])/(m-1);
        int ans = 1;
        while(start<=end) {
            int mid = start+(end-start)/2;
            if(canWePlace(position, mid, m)) {
                ans = mid;
                start=mid+1;
            } else {
                end = mid-1;
            }
        }
        return ans;
    }
    private static boolean canWePlace(int[] arr, int dist, int cows) {
        int cntCows=1;
        int last = arr[0];
        for (int j : arr) {
            if (j - last >= dist) {
                cntCows++;
                last = j;
            }
            if (cntCows >= cows) {
                return true;
            }
        }
        return false;
    }
}
