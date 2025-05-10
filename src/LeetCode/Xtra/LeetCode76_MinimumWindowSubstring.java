package Xtra;

import java.util.ArrayList;
import java.util.List;

public class LeetCode76_MinimumWindowSubstring {
    public static void main(String[] args) {
        String s1 = "ADOBECODEBANC", t1 = "ABC";
        String s2 = "a", t2 = "a";
        String s3 = "a", t3 = "aa";
        System.out.println(minWindow(s1,t1));
        System.out.println(minWindow(s2,t2));
        System.out.println(minWindow(s3,t3));
    }

    private static String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        List<Character> string = new ArrayList<>();
        for (char c : t.toCharArray()) {
            string.add(c);
        }
        System.out.println(string);
        StringBuilder answer = new StringBuilder();
        int count = 0;
        int i;
        for (i = 0; i < s.length(); i++) {
            answer.append(s.charAt(i));
            if (string.contains(s.charAt(i))) {
                count++;
                string.remove(s.charAt(i));
                if (count == n) {
                    break;
                }
            }
        }
        int start = i;
        int end = n;
        while (start < end) {


        }
        return answer.toString();
    }
}
