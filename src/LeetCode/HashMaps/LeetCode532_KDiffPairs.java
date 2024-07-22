package HashMaps;


import java.util.*;

public class LeetCode532_KDiffPairs {
    public static void main(String[] args) {
        int[] nums1 = {3, 1, 4, 1, 5};
        int k1 = 2;
        int[] nums2 = {1, 2, 3, 4, 5};
        int k2 = 1;
        int[] nums3 = {1, 3, 1, 5, 4};
        int k3 = 0;
        int[] nums4 = {1,1,1,1,1,2,2};
        int k4 = 0;
        System.out.println(findPairs(nums1, k1));
        System.out.println(findPairs(nums2, k2));
        System.out.println(findPairs(nums3, k3));
        System.out.println(findPairs(nums4, k4));
        System.out.println();
        System.out.println(findPairsHashmaps(nums1, k1));
        System.out.println(findPairsHashmaps(nums2, k2));
        System.out.println(findPairsHashmaps(nums3, k3));
        System.out.println(findPairsHashmaps(nums4, k4));
    }

    private static int findPairsHashmaps(int[] nums, int k) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        Arrays.stream(nums).forEach(num -> map.put(num, map.getOrDefault(num, 0) + 1));
        int count = 0;
        for (Integer key : map.keySet()) {
            if (k == 0 && map.get(key) > 1) {
                count++;
            } else if ((k > 0) && map.containsKey(key - k)) {
                count++;
            }
        }
        return count;
    }
    private static int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        boolean bol = true;
        for(int i =0 ;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                if(k==0 && bol){
                    count++;
                    bol = false;
                }
            }
            else {
                if (binarySearch(nums, i + 1, nums.length - 1, nums[i] + k) != -1) {
                    count++;
                }
                bol = true;
            }
        }
        return count;
    }
    private static int binarySearch(int[] nums, int start, int end, int target) {
        while (start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        }
        return -1;
    }

}