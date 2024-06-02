package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode3_LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s1 = "abba";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
////        System.out.println(lengthOfLongestSubstringTLE(s1));
////        System.out.println(lengthOfLongestSubstringTLE(s2));
////        System.out.println(lengthOfLongestSubstringTLE(s3));
////        System.out.println();
        System.out.println(lengthOfLongestSubstringSW(s1));
        System.out.println(lengthOfLongestSubstringSW(s2));
        System.out.println(lengthOfLongestSubstringSW(s3));
    }

    private static int lengthOfLongestSubstringTLE(String s) {
        int n = s.length();
        int maxLength = 0;
        List<String> substrings = new ArrayList<>();
        for(int i = 0;i<n;i++){
            HashMap<Character,Boolean> maps = new HashMap<>();
            int length = 0;
            for(int j = i;j<n;j++){
                if(maps.containsKey(s.charAt(j))){
                    break;
                }
                maps.put(s.charAt(j),true);
                substrings.add(s.substring(i,j+1));
                length++;
            }
            maxLength = Math.max(maxLength,length);
        }
        System.out.println(substrings);
        return maxLength;
    }

    private static int lengthOfLongestSubstringSW(String s) {
        int n = s.length();
        int l = 0;
        int r = 0;
        int maxLength = 0;
        HashMap<Character,Integer> maps = new HashMap<>();
        while (r<n){
            if (maps.containsKey(s.charAt(r)) && maps.get(s.charAt(r)) >= l) {
                l = maps.get(s.charAt(r)) + 1;
            }
            maxLength = Math.max(maxLength,r-l+1);
            maps.put(s.charAt(r), r);
            r++;
        }
        return maxLength;
    }
}
