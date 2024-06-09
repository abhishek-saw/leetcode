package HashMaps;

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode974_SubArraysDivByK {
    public static void main(String[] args) {
        int [] nums1 = {4,5,0,-2,-3,1};
        int k1 = 5;
        int [] nums2 = {5};
        int k2 = 9;
        int [] nums3 ={-1,2,9};
        int k3 = 2;
        int [] nums4 = {-1,-9,-4,0};
        int k4 = 9;
        int [] nums5 = {2,-2,2,-4};
        int k5 = 6;
//        System.out.println(subArraysDivByK(nums1,k1));
//        System.out.println(subArraysDivByK(nums2,k2));
//        System.out.println(subArraysDivByK(nums3,k3));
//        System.out.println(subArraysDivByK(nums4,k4));
//        System.out.println(subArraysDivByK(nums5,k5));
//        System.out.println();
//        System.out.println(subArraysDivByKBetter(nums1,k1));
        System.out.println(subArraysDivByKBetter(nums2,k2));
        System.out.println(subArraysDivByKBetter(nums3,k3));
        System.out.println(subArraysDivByKBetter(nums4,k4));
        System.out.println(subArraysDivByKBetter(nums5,k5));

    }

    private static int subArraysDivByKBetter(int[] nums, int k) {
        int [] divArray = new int[k];
        divArray[0] = 1;
        int sums = 0;
        int count = 0;
        for(int num : nums){
            sums+=num;
            int rem =sums%k;
            if(rem<0){
                rem+=k;
            }
            count+=divArray[rem];
            divArray[rem]++;
        }
        System.out.println(Arrays.toString(divArray));
        return count;
    }

    private static int subArraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> maps = new HashMap<>();
        maps.put(0,1);
        int sums = 0;
        int count = 0;
        for (int num : nums) {
            sums += num;
            int rem = sums%k;
            if(rem<0){
                rem+=k;
            }
            if (maps.containsKey(rem)) {
                count += maps.get(rem);
            }
            if (maps.containsKey(rem)) {
                maps.put(rem, maps.get(rem) + 1);
            } else {
                maps.put(rem, 1);
            }
        }
        return count;
    }
}
