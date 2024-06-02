package Math;

public class LeetCode509_Fibonacci {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(fibonacci(n));
    }

    private static int fibonacci(int n) {
        int [] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
