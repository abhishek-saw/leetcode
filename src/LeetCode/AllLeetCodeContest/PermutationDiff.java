package AllLeetCodeContest;

import java.util.HashMap;

public class PermutationDiff {
    public static void main(String[] args) {
        String s = "abcde";
        String t = "edbac";
        System.out.println(findPermutationDifference(s,t));

    }

    private static int findPermutationDifference(String s, String t) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i =0;i<s.length();i++){
            map1.put(s.charAt(i),i);
            map2.put(t.charAt(i),i);
        }
        int diff = 0;
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            diff+=Math.abs(map1.get(c)-map2.get(c));
        }
        return diff;

    }
}
