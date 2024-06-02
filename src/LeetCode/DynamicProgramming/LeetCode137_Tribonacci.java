package DynamicProgramming;

public class LeetCode137_Tribonacci {
    public static void main(String[] args) {
        int n = 0;
        System.out.println(tribonacci(n));
    }

    private static int tribonacci(int n) {
        int[] dp = new int [n+3];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i =3;i<dp.length;i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }
}
