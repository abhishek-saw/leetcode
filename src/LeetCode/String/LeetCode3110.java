package String;

public class LeetCode3110 {
    public static void main(String[] args) {
        String s = "hello";
        String s1 = "zaz";
        System.out.println(scoreOfString(s));
        System.out.println(scoreOfString(s1));

    }

    private static int scoreOfString(String s) {
        int score = 0;
        for(int i =1;i<s.length();i++){
            score+=(Math.abs(s.charAt(i)-s.charAt(i-1)));
        }
        return score;
    }
}
