package Array;


import java.util.Arrays;

public class LeetCode34_SearchRange {
    public static void main(String[] args) {
        int [] nums = {5,7,7,8,8,10};
        int target = 8;
        int [] answer = searchRange(nums,target);
        System.out.println(Arrays.toString(answer));
    }
    public static int[] searchRange(int[] nums, int target) {
        int start = binarySearch1(nums,target);
        int end = binarySearch2(nums,target);
        return new int[]{start,end};
    }
    private static int binarySearch2(int[] nums, int target) {
        int s = 0;
        int e = nums.length-1;
        int index = -1;
        while(s<=e){
            int mid = (s+e)/2;
            if(nums[mid]< target){
                s = mid + 1;
            } else if (nums[mid]>target) {
                e = mid -1;
            } else {
                index = mid;
                s++;
            }
        }
        return index;
    }
    private static int binarySearch1(int[] nums, int target) {
        int s = 0;
        int e = nums.length-1;
        int index = -1;
        while(s<=e){
            int mid = (s+e)/2;
            if(nums[mid]>= target){
                e = mid-1;
            } else {
                s = mid+1;
            }
            if(nums[mid] ==target){
                index = mid;
            }
        }
        return index;
    }
}
