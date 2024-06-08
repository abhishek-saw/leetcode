package HashMaps;


import java.util.HashMap;

public class LeetCode523_CheckSubArraySum {
    public static void main(String[] args) {
        int[] nums1 = {23, 2, 4, 6, 7};
        int k1 = 6;
        int[] nums2 = {23, 2, 6, 4, 7};
        int k2 = 6;
        int[] nums3 = {5,0,0,0};
        int k3 = 3;
        int[] nums4 = {23,2,4,6,6};
        int k4 = 7;
        int[] nums5 = {0,0};
        int k5 = 1;
        int[] nums6 = {0,1,0,3,0,4,0,4,0};
        int k6 = 5;
        System.out.println(checkSubArraySum(nums1, k1));
        System.out.println(checkSubArraySum(nums2, k2));
        System.out.println(checkSubArraySum(nums3, k3));
        System.out.println(checkSubArraySum(nums4, k4));
        System.out.println(checkSubArraySum(nums5, k5));
        System.out.println(checkSubArraySum(nums6, k6));
        System.out.println();
        System.out.println(checkSubArraySumBetter(nums1, k1));
        System.out.println(checkSubArraySumBetter(nums2, k2));
        System.out.println(checkSubArraySumBetter(nums3, k3));
        System.out.println(checkSubArraySumBetter(nums4, k4));
        System.out.println(checkSubArraySumBetter(nums5, k5));
        System.out.println(checkSubArraySumBetter(nums6, k6));
    }

    private static boolean checkSubArraySumBetter(int[] nums, int k) {
        if(nums.length<2){
            return false;
        }
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(0,-1);
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum+=nums[i];
            if(hashMap.containsKey(sum%k)){
                if(i-hashMap.get(sum%k)>=2){
                    return true;
                }
            }
            else {
                hashMap.put(sum%k,i);
            }
        }
        return false;
    }
    private static boolean checkSubArraySum(int[] nums, int k) {
        for(int i =0;i<nums.length;i++){
            int sum = nums[i];
            for(int j =i+1;j<nums.length;j++){
                sum+=nums[j];
                if(sum%k==0){
                    return true;
                }
            }
        }
        return false;
    }
}