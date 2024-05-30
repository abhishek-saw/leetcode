package BackTracking;

import java.util.*;

public class CountTriplets {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 6, 7};
        int[] nums2 = {1,1,1,1,1};
        System.out.println(countTriplets(nums1));
        System.out.println(countTriplets(nums2));
    }

    private static int countTriplets(int[] nums) {
        int n = nums.length;
        int xor = 0;
        int[] xorArray = new int[n+1];
        for(int i = 0;i<n;i++){
            xor^=nums[i];
            xorArray[i+1] = xor;
        }
        System.out.println(Arrays.toString(xorArray));
        int count = 0;
        for(int i =0;i<=n;i++){
            for(int j=i+1;j<=n;j++){
                if(xorArray[i] == xorArray[j]) {
                    count += (j - i - 1);
                }
            }
        }
        return count;
    }
}