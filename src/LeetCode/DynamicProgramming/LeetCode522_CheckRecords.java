package DynamicProgramming;

public class LeetCode522_CheckRecords {
    public static void main(String[] args) {
        int n1 = 2;
        int n2 = 1;
        int n3 = 10101;
        System.out.println(checkRecord(n1));
        System.out.println(checkRecord(n2));
        System.out.println(checkRecord(n3));

    }
    public static int checkRecord(int n) {
        final int MOD = 1000000007;
        int[][][] f = new int[n + 1][2][3];

        f[0] = new int[][]{{1, 1, 1}, {1, 1, 1}};
        for (int i = 1; i <= n; i++)
            for (int j = 0; j < 2; j++)
                for (int k = 0; k < 3; k++) {
                    int val = f[i - 1][j][2]; // ...P
                    if (j > 0) val = (val + f[i - 1][j - 1][2]) % MOD; // ...A
                    if (k > 0) val = (val + f[i - 1][j][k - 1]) % MOD; // ...L
                    f[i][j][k] = val;
                }
        return f[n][1][2];
    }
}
