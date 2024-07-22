package String;

import java.util.ArrayList;

public class LeetCode125_IsPalindrome {
    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 = " ";
        String s4 = "0P";
        String s5 = "`l;`` 1o1 ??;l`";
        System.out.println(isPalindrome(s1));
        System.out.println(isPalindrome(s2));
        System.out.println(isPalindrome(s3));
        System.out.println(isPalindrome(s4));
        System.out.println(isPalindrome(s5));
    }

    private static boolean isPalindrome(String s) {
        ArrayList<Character> string = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if ((c >= 'A' && c <= 'Z')){
                c+=32;
            }
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                string.add(c);
            }
        }
        int start = 0;
        int end = string.size() - 1;
        while (start <= end) {
            if (string.get(start) != string.get(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}