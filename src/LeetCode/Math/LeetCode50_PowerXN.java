package Math;

public class LeetCode50_PowerXN {
    public static void main(String[] args) {
        double x = 0.00001;
        int n = 2147483647;
        System.out.println(myPow(x, n));
        System.out.println(myPow(x, -2));
        System.out.println(myPow(2.1, 3));

    }

    private static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        // Convert n to a long integer to handle the edge case with Integer.MIN_VALUE
        long N = n;

        // If n is negative, take the reciprocal of x and make N positive
        if (N < 0) {
            N = -N;
            x = 1 / x;
        }

        // If N is even, recursively compute the square of x^(N/2)
        if (N % 2 == 0) {
            return myPow(x * x, (int) (N / 2));
        }

        // If N is odd, recursively compute x^(N-1) and multiply it by x
        else {
            return x * myPow(x, (int) (N - 1));
        }
    }
}