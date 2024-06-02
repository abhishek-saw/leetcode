package Array;

public class LeetCode33_FindMinimum {
    public static void main(String[] args) {
        int [] arr = {4,5,6,7,0,1,2};
        System.out.println(findMinimum(arr,0));
        System.out.println(findMinimum(arr,3));
    }

    private static int findMinimum(int[] nums,int target) {
        int start = 0;
        int end = nums.length-1;
        int mid;
        while(start<=end){
            mid = start + (end-start)/2;
            if(target==nums[mid]){
                return mid;
            }
            if (nums[start]<=nums[mid]){ //left half sorted
                if(nums[start]<=target && nums[mid]>target ) {
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }
            else {//right half sorted
                if(nums[mid]<target && nums[end]>=target ) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
