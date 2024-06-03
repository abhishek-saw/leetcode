package String;

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode567_PermutationString {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        String s3 = "eidboaoo";
        System.out.println(checkInclusion(s1,s2));
        System.out.println(checkInclusion(s1,s3));
        System.out.println(checkInclusion("hello","ooolleoooleh"));
        System.out.println(checkInclusionBetter(s1,s2));
        System.out.println(checkInclusionBetter(s1,s3));
        System.out.println(checkInclusionBetter("hello","ooolleoooleh"));

    }

    private static boolean checkInclusionBetter(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        int [] s1Map = new int[26];
        int [] s2Map = new int[26];
        if(s1Len>s2Len){
            return false;
        }
        int start = 0;
        while (start<s1Len){
            s1Map[s1.charAt(start)-'a']++;
            s2Map[s2.charAt(start)-'a']++;
            start++;
        }
        if (Arrays.equals(s1Map, s2Map)) {
            return true;
        }
        for(int i = s1Len;i<s2Len;i++){
            s2Map[s2.charAt(i)-'a']++;
            s2Map[s2.charAt(i-start)-'a']--;
            if (Arrays.equals(s1Map, s2Map)) {
                return true;
            }
        }
        return Arrays.equals(s1Map, s2Map);
    }
    private static boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> maps = new HashMap<>();
        for(char chars: s1.toCharArray()){
            if(maps.containsKey(chars)){
                maps.put(chars,maps.get(chars)+1);

            }
            else {
                maps.put(chars, 1);
            }
        }
        System.out.println(maps);
        for(int i =0;i<s2.length()-s1.length()+1;i++){
            if(checkPermutations(s2.substring(i,i+s1.length()),maps)){
                return true;
            }
        }
        return false;
    }

    private static boolean checkPermutations(String substring, HashMap<Character, Integer> maps) {
        HashMap<Character,Integer> maps2 = new HashMap<>();
        for(char chars: substring.toCharArray()){
            if(maps2.containsKey(chars)){
                maps2.put(chars,maps2.get(chars)+1);

            }
            else {
                maps2.put(chars, 1);
            }
        }
        return maps.equals(maps2);
    }
}
