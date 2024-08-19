package DynamicProgramming;

public class LeetCode650_KeysKeyboard {
    private static int i;

    public static void main(String[] args) {
        int n1 = 0;
        int n2 = 3;
        int n3 = 1;
        System.out.println(minSteps(n1));
        System.out.println(minSteps(n2));
        System.out.println(minSteps(n3));
        System.out.println(minStepsBetter(n1));
        System.out.println(minStepsBetter(n2));
        System.out.println(minStepsBetter(n3));
    }

    private static int minStepsBetter(int n) {
        int [] dp = new int[1001];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 2;
        for(int i =3;i<=n;i++){
            int factor = i/2;
            while (factor>=1){
                if (i % factor == 0) {
                    int step = dp[factor];
                    int copy = 1;
                    int paste = i/factor-1;
                    dp[i] = step + copy + paste;
                    break;
                }
                else {
                    factor--;
                }
            }
        }
        return dp[n];
    }

    private static int minSteps(int n) {
        if(n<2){
            return 0;
        }
        int [][] memo = new int[1001][1001];
        return 1 + solve(1,1,n,memo);
    }
    private static int solve(int currA, int clipA, int n, int[][] memo) {
        if(currA==n){
            return 0;
        }
        if(currA>n){
            return 1000000;
        }
        if(memo[currA][clipA]!=0){
            return memo[currA][clipA];
        }
        int copyAllPaste = 1 + 1 + solve(currA+currA,currA,n, memo);
        int paste = 1 + solve(currA+clipA,clipA,n, memo);
        memo[currA][clipA] = Math.min(copyAllPaste,paste);
        return memo[currA][clipA];
    }
}
