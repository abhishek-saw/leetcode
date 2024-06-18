package Array;

public class LeetCode633_SumOfSquareNumbers {
    public static void main(String[] args) {
        int c1 = 5;
        int c2 = 3;
        int c3 = 2147483600;
        int c4 = 2;
        int c5 = 1000;
        System.out.println(judgeSquareSum(c1));
        System.out.println(judgeSquareSum(c2));
        System.out.println(judgeSquareSum(c3));
        System.out.println(judgeSquareSum(c4));
        System.out.println(judgeSquareSum(c5));
        System.out.println(judgeSquareSumBinary(c1));
        System.out.println(judgeSquareSumBinary(c2));
        System.out.println(judgeSquareSumBinary(c3));
        System.out.println(judgeSquareSumBinary(c4));
        System.out.println(judgeSquareSumBinary(c5));
    }

    private static boolean judgeSquareSumBinary(int c) {
        for(long a = 0;a*a<=c;a++){
            long x = (long) (c - Math.pow(a,2));
            long start  =0;
            long end = x;
            while (start<=end){
                long mid = start +(end-start)/2;
                if(mid*mid==x){
                    return true;
                }
                else if(mid*mid>x){
                    end = mid -1;
                }
                else {
                    start = mid+1;
                }
            }
        }
        return false;
    }

    private static boolean judgeSquareSum(int c) {
        long a = 0;
        long b = (int) Math.pow(c,0.5);
        while (a<=b){
            long sum = (long) (Math.pow(a, 2) + Math.pow(b, 2));
            if(sum <c){
                a++;
            }
            else if(c<sum){
                b--;
            }
            else {
             return true;
            }
        }
        return false;
    }
}
