package Array;

import java.util.Arrays;

public class LeetCode322_CoinChange {
    public static void main(String[] args) {
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        int[] coins2 = {2};
        int amount2 = 3;
        int[] coins3 = {1, 2, 5};
        int amount3 = 100;
        int[] coins4 = {2, 5, 10, 1};
        int amount4 = 27;
        int[] coins5 = {186,419,83,408};
        int amount5 = 6249;
        int[] coins6 = {411,412,413,414,415,416,417,418,419,420,421,422};
        int amount6 = 9864;
        System.out.println(coinChange(coins1, amount1));
        System.out.println(coinChange(coins2, amount2));
        System.out.println(coinChange(coins3, amount3));
        System.out.println(coinChange(coins4, amount4));
        System.out.println(coinChange(coins5, amount5));
        System.out.println(coinChange(coins6, amount6));
        System.out.println();
        System.out.println(coinChangeDP(coins1, amount1));
        System.out.println(coinChangeDP(coins2, amount2));
        System.out.println(coinChangeDP(coins3, amount3));
        System.out.println(coinChangeDP(coins4, amount4));
        System.out.println(coinChangeDP(coins5, amount5));
        System.out.println(coinChangeDP(coins6, amount6));
    }

    private static int coinChangeDP(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int j = 0; j < dp[0].length; j++) {
            if (j % coins[0] == 0) {
                dp[0][j] = j / coins[0];
            } else {
                dp[0][j] = (int) 1e9;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                int notTaken = dp[i-1][j];
                int taken = Integer.MAX_VALUE;
                if (coins[i] <= j) {
                    taken = 1 + dp[i][j-coins[i]];
                }
                dp[i][j] = Math.min(taken,notTaken);
            }
        }
        int answer = dp[coins.length-1][amount];
        return answer >= 1e9 ? -1 : answer;

    }
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int answer = coinChangeHelper(coins, amount, coins.length - 1, dp);
        return answer >= 1e9 ? -1 : answer;
    }
    private static int coinChangeHelper(int[] coins, int amount, int index, int[][] dp) {
        if (index == 0) {
            if (amount % coins[index] == 0) {
                return amount / coins[0];
            } else {
                return (int) 1e9;
            }
        }
        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }
        int notTaken = coinChangeHelper(coins, amount, index - 1, dp);
        int taken = Integer.MAX_VALUE;
        if (coins[index] <= amount) {
            taken = 1 + coinChangeHelper(coins, amount - coins[index], index, dp);
        }
        dp[index][amount] = Math.min(notTaken, taken);
        return dp[index][amount];
    }
}
