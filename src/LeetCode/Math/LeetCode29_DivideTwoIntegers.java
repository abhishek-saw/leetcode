package Math;

public class LeetCode29_DivideTwoIntegers {
    public static void main(String[] args) {
        int dividend1 = 22;
        int divisor1 = 3;
        int dividend2 = -2147483648;
        int divisor2 = -1;
        System.out.println(divide1(dividend1, divisor1));
        System.out.println(divide1(dividend2, divisor2));
    }

    public static int divide1(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean isNegative = false;
        if (dividend < 0 || divisor < 0) {
            isNegative = true;
        }
        if (dividend < 0 && divisor < 0) {
            isNegative = false;
        }
        int n = Math.abs(dividend);
        int d = Math.abs(divisor);
        int quotient = 0;
        while (n - d >= 0) { // 22-3>=0 || 10-3>=0 || 4-3>=0 || 1-3>=0
            int count = 0;
            while (n - (d << 1 << count) >= 0) {
//                count 0 -> 22- 3*2^0 >=0 ==> 19>=0  || 10- 3*2^0 >=0 ==> 7>=0 || 4- 3*2^0 >=0 ==> 1>=0
//                count 1 -> 22- 3*2^1 >=0 ==> 16>=0  || 10- 3*2^1 >=0 ==> 4>=0 || 4- 3*2^1 >=0 ==> -2>=0 false
//                count 2 -> 22- 3*2^2 >=0 ==> 10>=0  || 10- 3*2^2 >=0 ==> -1>=0 false
//                count 0 -> 22- 3*2^3 >=0 ==> -2>=0 false
                count++; //count==2 || count==1 || count==0 ;
            }
            quotient += 1 << count; // quotient -> 0 + 2^(0+2) ==> 4 || 4 + 2^(0+1) ==> 6 || 6 + 2^(0+0) ==> 7==quotient
            n = n - (d << count); // n -> 22 - 3*2^(0+2) ==> 10 || 10 - 3*2^(0+1) ==> 4 || 4 - 3*2^(0+0) ==> 1
        }
        return isNegative ? -quotient : quotient;
    }
}