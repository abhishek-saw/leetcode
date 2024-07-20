package AllLeetCodeContest;


import java.util.Arrays;

public class LeetCode3222_MinimumLength {
    public static void main(String[] args) {
        String s1 = "abaacbcbb";
        String s2 = "aa";
        System.out.println(minimumLength(s1));
        System.out.println(minimumLength(s2));
    }

    private static int minimumLength(String s) {
        int[] array = new int[26];
        for (char c : s.toCharArray()) {
            array[c - 'a']++;
        }
        System.out.println(Arrays.toString(array));
        int res = 0;
        for (int qty : array) {
            if (qty < 3)
                res += qty;
            else {
                qty = qty % 2;
                if (qty == 0) {
                    qty = 2;
                }
                res += qty;
            }
        }
        return res;
    }
}