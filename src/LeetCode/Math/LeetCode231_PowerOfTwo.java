package Math;

public class LeetCode231_PowerOfTwo {
    public static void main(String[] args) {
        int n1 = 16;
        int n2 = 1;
        int n3 = 0;
        System.out.println(isPowerOfTwo(n1));
        System.out.println(isPowerOfTwo(n2));
        System.out.println(isPowerOfTwo(n3));
    }

    private static boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        } else if (n == 1) {
            return true;
        } else {
            if (n % 2 != 0) {
                return false;
            }
            return isPowerOfTwo(n / 2);
        }
    }
}