package DynamicProgramming;

import java.util.Arrays;

public class ClimbStairs {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(climbStairs(n));
    }

    private static int climbStairs(int n) {
        int [] dp = new int[n+1];
        dp[0] = 1;
        if(n>0) {
            dp[1] = 1;
            for (int i = 2; i < dp.length; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
