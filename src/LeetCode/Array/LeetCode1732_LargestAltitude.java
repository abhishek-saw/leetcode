package Array;

public class LeetCode1732_LargestAltitude {
    public static void main(String[] args) {
        int[] gain1 = {-5,1,5,0,-7};
        int[] gain2 = {-4,-3,-2,-1,4,3,2};
        System.out.println(largestAltitude(gain1));
        System.out.println(largestAltitude(gain2));
    }

    private static int largestAltitude(int[] gain){
        int prefixSum = 0;
        int altitude = 0;
        for (int i : gain) {
            prefixSum += i;
            altitude = Math.max(altitude, prefixSum);
        }
        return altitude;
    }
}
