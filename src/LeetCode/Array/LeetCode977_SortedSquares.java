package Array;

import java.util.Arrays;

public class LeetCode977_SortedSquares {
    public static void main(String[] args) {
        int [] nums = {-5,-4,-1,0,3,10};
        System.out.println(Arrays.toString(nums));
        int [] answer = sortedSquares(nums);
        System.out.println(Arrays.toString(answer));
    }

    private static int[] sortedSquares(int[] nums) {
        int [] answer = new int[nums.length];
        int start = 0;
        int end = nums.length-1;
        int index = nums.length-1;
        while(start<=end){
            if(Math.abs(nums[start])>Math.abs(nums[end])){
                answer[index] = nums[start]*nums[start];
                index--;
                start++;
            }
            else {
                answer[index] = nums[end]*nums[end];
                index--;
                end--;
            }
        }
        return answer;
    }
}
