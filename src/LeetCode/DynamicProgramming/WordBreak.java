package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        List<String> wordDict1 = new ArrayList<>(List.of("leet","code"));
        String s1 = "leetcode";
        List<String> wordDict2 = new ArrayList<>(List.of("apple","pen"));
        String s2 = "applepenapple";
        List<String> wordDict3 = new ArrayList<>(List.of("aaaa","aaa"));
        String s3 = "aaaaaaa";
        List<String> wordDict4 = new ArrayList<>(List.of("dog","gs"));
        String s4 = "dogs";
        System.out.println(wordBreak(s1,wordDict1));
        System.out.println(wordBreak(s2,wordDict2));
        System.out.println(wordBreak(s3,wordDict3));
        System.out.println(wordBreak(s4,wordDict4));
    }

    private static boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[301];
        return wordBreakHelper(0,s,wordDict) && wordBreakMemo(0,memo,s,wordDict);
    }

    private static boolean wordBreakMemo(int index, Boolean[] memo, String s, List<String> wordDict) {
        if(index==s.length()){
            return true;
        }
        if(memo[index]!=null){
            return true;
        }
        for(int endIndex =index+1 ;endIndex<=s.length();endIndex++){
            if(wordDict.contains(s.substring(index,endIndex)) && wordBreakMemo(endIndex,memo,s,wordDict)){
                return memo[index] = true;
            }
        }
        return memo[index] = false;
    }

    private static boolean wordBreakHelper(int index, String s, List<String> wordDict) {
        if(index>=s.length()){
            return true;
        }
        if(wordDict.contains(s)){
            return true;
        }
        for(int endIndex =index+1 ;endIndex<=s.length();endIndex++){
            if(wordDict.contains(s.substring(index,endIndex)) && wordBreakHelper(endIndex,s,wordDict)){
                return true;
            }
        }
        return false;
    }
}
