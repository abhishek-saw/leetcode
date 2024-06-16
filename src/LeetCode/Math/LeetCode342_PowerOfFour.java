package Math;

public class LeetCode342_PowerOfFour {
    public static void main(String[] args) {
        int n1 = 16;
        int n2 = 5;
        int n3 = 1;
        System.out.println(isPowerOfFour(n1));
        System.out.println(isPowerOfFour(n2));
        System.out.println(isPowerOfFour(n3));
        System.out.println(isPowerOfFourShort(n1));
        System.out.println(isPowerOfFourShort(n2));
        System.out.println(isPowerOfFourShort(n3));
        System.out.println(isPowerOfFourLog(n1));
        System.out.println(isPowerOfFourLog(n2));
        System.out.println(isPowerOfFourLog(n3));


    }

    private static boolean isPowerOfFourShort(int n) {
        return n > 0 && (n&(n-1)) == 0 && (n & 0x55555555) != 0;
    }
    private static boolean isPowerOfFourLog(int n) {
        if(n<=0)
        {
            return false;
        }
        return Math.log(n)/Math.log(4)%1==0;
    }

    private static boolean isPowerOfFour(int n) {
        if(n<=0){
            return false;
        }
        else if(n==1){
            return true;
        }
        else {
            if(n%4!=0){
                return false;
            }
            else {
                return isPowerOfFour(n/4);
            }
        }
    }
}
