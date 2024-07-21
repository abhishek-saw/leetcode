package Array;

import java.util.Arrays;

public class LeetCode238_ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4};
        int[] nums2 = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf(nums1)));
        System.out.println(Arrays.toString(productExceptSelf(nums2)));

    }

    private static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int [] prefix = new int[n];
        int [] postfix = new int[n];
        prefix[0]=1;
        postfix[n-1]=1;
        for (int i = 1;i<n;i++){
            prefix[i] = prefix[i-1]*nums[i-1];
            postfix[n-i-1] = postfix[n-i]*nums[n-i];
        }
//        System.out.println(Arrays.toString(prefix));
//        System.out.println(Arrays.toString(postfix));
        int[] answer = new int[n];
        for (int i = 0;i<n;i++){
            answer[i] = prefix[i]*postfix[i];
        }
        return answer;
    }
}
