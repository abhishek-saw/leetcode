package Array;

import java.util.*;

public class LeetCode239_MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums1 = {1,3,-1,-3,5,3,6,7};
        int k1 = 3;
        int[] nums2 = {1};
        int k2 = 3;
        int[] nums3 = {9,10,9,-7,-4,-8,2,-6};
        int k3 = 5;
        System.out.println(Arrays.toString(maxSlidingWindow(nums1, k1)));
        System.out.println(Arrays.toString(maxSlidingWindow(nums2, k2)));
        System.out.println(Arrays.toString(maxSlidingWindow(nums3, k3)));
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || nums.length == 1) {
            return nums;
        }
        int n = nums.length;
        int[] answer = new int[n - k + 1];
        int index = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.getFirst() <= i - k) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[i] >= nums[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
            if (i >= k - 1) {
                answer[index] = nums[deque.getFirst()];
                index++;
            }
        }
        return answer;
    }
}
