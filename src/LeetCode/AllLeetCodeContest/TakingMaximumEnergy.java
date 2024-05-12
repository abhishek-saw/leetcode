package AllLeetCodeContest;

import java.util.PriorityQueue;

public class TakingMaximumEnergy {
    public static void main(String[] args) {
        int[] energy = {-2,-3,-1};
        int k = 2;
        int[] energy1 = {-50000, -10, 4, 3, 5, -9, 9, -7};
        int k1 = 2;
        int[] energy2 = {-9,-2,-6,-5,-8,3,0};
        int k2 = 1;
//        System.out.println(maximumEnergy(energy, k));
//        System.out.println(maximumEnergy(energy1, k1));
//        System.out.println(maximumEnergy(energy2, k2));
        System.out.println(maximumEnergy1(energy, k));
        System.out.println(maximumEnergy1(energy1, k1));
        System.out.println(maximumEnergy1(energy2, k2));
    }

//    private static int maximumEnergy(int[] energy, int k) {
//        if (energy.length == 0) {
//            return 0;
//        }
//        int ans = Integer.MIN_VALUE;
//        for (int i = 0; i <= k; i++) {
//            int smallSum = 0;
//            for (int j = i; j < energy.length; j += k) {
//                int n = energy[j];
//                smallSum += energy[j];
//                ans = Math.max(ans, smallSum);
//            }
//
//        }
//        return ans;
//    }

    private static int maximumEnergy1(int[] energy, int k) {
        if (energy.length == 0) {
            return 0;
        }
        int ans = Integer.MIN_VALUE;
        for (int i = energy.length-1; i >=energy.length-k; i--) {
            int smallSum = 0;
            for (int j = i; j >=0; j -= k) {
                smallSum += energy[j];
                ans = Math.max(ans, smallSum);
            }

        }
        return ans;
    }
}