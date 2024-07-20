package String;

import java.util.HashSet;
import java.util.List;

public class LeetCode1456_MaxVowels {
    public static void main(String[] args) {
        String s1 = "abciiidef";
        int k1 = 3;
        String s2 = "aeiou";
        int k2 = 2;
        String s3 = "leetcode";
        int k3 = 3;
        String s4 = "weallloveyou";
        int k4 = 7;
        System.out.println(maxVowels(s1, k1));
        System.out.println(maxVowels(s2, k2));
        System.out.println(maxVowels(s3, k3));
        System.out.println(maxVowels(s4, k4));
    }

    private static int maxVowels(String s, int k) {
        int count = 0;
        HashSet<Character> maps = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        for (int i = 0; i < k; i++) {
            if(maps.contains(s.charAt(i))){
                count++;
            }
        }
        int maxCount = count;
        for (int i = k; i < s.length(); i++) {
            if(maps.contains(s.charAt(i-k))){
                count--;
            }
            if(maps.contains(s.charAt(i))){
                count++;
            }
            maxCount = Math.max(maxCount,count);
            if(maxCount==k){
                return k;
            }
        }
        return maxCount;
    }
}