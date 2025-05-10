package Xtra;

import java.util.HashMap;

public class LeetCode1143_LongestCommonSubsequence {
    static int longest = 0;
    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        String text3 = "abc", text4 = "abc";
        String text5 = "abc", text6 = "def";
        System.out.println(longestCommonSubsequence(text1,text2));
        longest=0;
        System.out.println(longestCommonSubsequence(text3,text4));
        longest=0;
        System.out.println(longestCommonSubsequence(text5,text6));
    }

    private static int longestCommonSubsequence(String text1, String text2) {
        HashMap<String,Integer> subsequence1 = new HashMap<>();
        findSubsequence(text1,"",subsequence1);
        HashMap<String,Integer> subsequence2 = new HashMap<>();
        findSubsequenceCompare(text2,"",subsequence2,subsequence1);
        System.out.println(subsequence1);
        System.out.println(subsequence2);
        return longest;
    }
    private static void findSubsequenceCompare(String text2, String string, HashMap<String, Integer> subsequence2,HashMap<String, Integer> subsequence1) {
        if(text2.isEmpty()){
            if(subsequence1.containsKey(string)){
                longest = Math.max(longest,string.length());
            }
            subsequence2.put(string,string.length());
            return;
        }
        findSubsequenceCompare(text2.substring(1),string+text2.charAt(0),subsequence2,subsequence1);
        findSubsequenceCompare(text2.substring(1),string,subsequence2,subsequence1);}
    private static void findSubsequence(String text1, String string,  HashMap<String,Integer> subsequence1) {
        if(text1.isEmpty()){
            subsequence1.put(string,string.length());
            return;
        }
        findSubsequence(text1.substring(1),string+text1.charAt(0),subsequence1);
        findSubsequence(text1.substring(1),string,subsequence1);
    }
}
