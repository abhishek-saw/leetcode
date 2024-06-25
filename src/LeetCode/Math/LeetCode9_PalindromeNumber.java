package Math;


public class LeetCode9_PalindromeNumber {
    public static void main(String[] args) {
        int x1 = 121;
        int x2 = -121;
        int x3 = 10;
        int x4 = 214753647;
        System.out.println(isPalindrome(x1));
        System.out.println(isPalindrome(x2));
        System.out.println(isPalindrome(x3));
        System.out.println(isPalindrome(x4));
    }

    private static boolean isPalindrome(int x) {
        if(x<0) {
            return false;
        }
        long XReverse = reverse(x);
        return x == XReverse;
    }
    public static int reverse(int x) {
        long answer = reverseHelper(Math.abs(x));
        if(answer>=2147483647 || answer<-2147483646){
            return 0;
        }
        return (int) (x<0 ? -answer : answer);
    }

    private static long reverseHelper(int abs) {
        long answer = 0;
        while(abs>0){
            answer = 10*answer + abs%10;
            abs = abs/10;
        }
        return answer;
    }

}
