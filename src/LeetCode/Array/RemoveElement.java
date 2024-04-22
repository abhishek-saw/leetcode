package Array;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int [] nums = {3,2,2,3};
        int val = 3;
        System.out.println(Arrays.toString(nums));
        int answer = removeElement(nums,val);
        System.out.println(answer);
        System.out.println(Arrays.toString(nums));
    }

    private static int removeElement(int[] nums, int val) {
        int start = 0;
        int end = nums.length-1;
        int count = 0;
        while (start<=end){
            if(nums[end]==val){
                count++;
                end--;
            }
            else if(nums[start]==val){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
                count++;
            }
            else {
                start++;
            }
        }
        return nums.length-count;
    }
}
