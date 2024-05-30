package DynamicProgramming;

import java.util.Arrays;

import static Math.RotateImage.print;

public class UniquePathI {
    static int count ;
    public static void main(String[] args) {
        int m1 = 7;
        int n1 = 3;
        int m2 = 3;
        int n2 = 2;
        System.out.println(uniquePaths(m1,n1));
        System.out.println(uniquePathsSlow(m1,n1));
        count=0;
        System.out.println(uniquePathsSlow(m2,n2));


    }

    private static int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        for(int i =0;i<n;i++){
            dp[i][m-1] =1;
        }
        for(int j =0;j<m;j++){
            dp[n-1][j] =1;
        }
        for(int i = n-2;i>=0;i--){
            for(int j =m-2;j>=0;j--){
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        print(dp);
        return dp[0][0];

    }

    private static int uniquePathsSlow(int m, int n) {
        int [][] paths = new int[m][n];
        backTracking(paths,0,0,m,n);
        return count;
    }
    private static void backTracking(int[][] paths, int i, int j,int m,int n) {
        if(i<0 || j<0 ||i>m-1||j>n-1||paths[i][j]==1){
            return;
        }
        paths[i][j]=1;
        if(i==m-1 && j==n-1){
            paths[i][j]=0;
            count++;
            return;
        }
        backTracking(paths,i+1,j,m,n);
        backTracking(paths,i,j+1,m,n);
        paths[i][j]=0;
    }
}
