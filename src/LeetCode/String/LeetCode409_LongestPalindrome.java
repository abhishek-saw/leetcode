package String;

import java.util.HashMap;

public class LeetCode409_LongestPalindrome {
    public static void main(String[] args) {
        String s1 = "abccccdd";
        String s2 = "AAAAAA";
        System.out.println(longestPalindrome1(s1));
        System.out.println(longestPalindrome1(s2));
        System.out.println(longestPalindrome2(s1));
        System.out.println(longestPalindrome2(s2));
        System.out.println(longestPalindrome3(s1));
        System.out.println(longestPalindrome3(s2));
    }

    private static int longestPalindrome3(String s) {
        int oddFreq = 0;
        int [] arrays = new int[256];
        for (char chars : s.toCharArray()){
            arrays[chars]++;
            if(arrays[chars]%2!=0){
                oddFreq++;
            }
            else {
                oddFreq--;
            }
        }
        return oddFreq>0? s.length()-oddFreq+1:s.length();
    }

    private static int longestPalindrome2(String s) {
        int [] arrays = new int[256];
        for(char chars : s.toCharArray()){
            arrays[chars-'A']++;
        }
        int count = 0;
        boolean flag = false;
        for(int integers : arrays){
            if(integers%2==0){
                count+=integers;
            }
            else {
                count+=integers-1;
                flag = true;
            }
        }
        return flag?count+1:count;
    }

    private static int longestPalindrome1(String s) {
        HashMap<Character, Integer> maps = new HashMap<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (maps.containsKey(s.charAt(i))) {
                count += 2;
                maps.remove(s.charAt(i));
            } else {
                maps.put(s.charAt(i), 1);
            }
        }
        return maps.isEmpty() ? count : count+1;
    }
}