package DynamicProgramming;

import java.util.Arrays;

public class EditDistance {
    static int[][] dp;
    public static void main(String[] args) {
        String word1  = "horse";
        String word2 = "ros";
        System.out.println(minDistance(word1,word2));
        System.out.println(minDistanceBetter(word1,word2));

    }
    private static int minDistance(String word1, String word2){
        dp = new int[word1.length()][word2.length()];
        for(int[] d: dp)
            Arrays.fill(d, -1);
        return min(word1, word2,word1.length()-1, word2.length()-1);
    }

    public static int min(String s1, String s2, int i, int j) {
        if(i<0 ) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)== s2.charAt(j)) return dp[i][j]=min(s1,s2, i-1, j-1);

        else{
            return dp[i][j]= Math.min(1+min(s1,s2, i-1, j-1), Math.min(1+min(s1,s2, i-1, j), 1+min(s1,s2, i, j-1)));
        }
    }
    private static int minDistanceBetter(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int[] array:dp){
            Arrays.fill(array,0);
        }
        for(int i = word1.length();i>=0;i--) {
            for (int j = word2.length(); j >=0; j--) {
                if (i==word1.length()|| j==word2.length()){
                    dp[i][j] = Math.abs(word1.length()-i) + Math.abs(word2.length()-j) ;
                }
                else if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    int a = 1 + dp[i][j + 1];
                    int b = 1 + dp[i + 1][j];
                    int c = 1 + dp[i + 1][j + 1];
                    dp[i][j] =  Math.min(a, Math.min(b, c));
                }
            }
        }
        return dp[0][0];
    }
}
