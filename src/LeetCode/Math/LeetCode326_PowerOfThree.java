package Math;

public class LeetCode326_PowerOfThree {
    public static void main(String[] args) {
        int n1 = 27;
        int n2 = 0;
        int n3 = -1;
        System.out.println(isPowerOfThree(n1));
        System.out.println(isPowerOfThree(n2));
        System.out.println(isPowerOfThree(n3));
        System.out.println(isPowerOfThreeShort(n1));
        System.out.println(isPowerOfThreeShort(n2));
        System.out.println(isPowerOfThreeShort(n3));
        System.out.println(isPowerOfThreeLog(n1));
        System.out.println(isPowerOfThreeLog(n2));
        System.out.println(isPowerOfThreeLog(n3));


    }

    private static boolean isPowerOfThreeShort(int n) {
        return ( n>0 &&  1162261467%n==0);
    }
    private static boolean isPowerOfThreeLog(int n) {

        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    private static boolean isPowerOfThree(int n) {
        if(n<=0){
            return false;
        }
        else if(n==1){
            return true;
        }
        else {
            if(n%3!=0){
                return false;
            }
            else {
                return isPowerOfThree(n/3);
            }
        }
    }
}
