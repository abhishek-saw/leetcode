package Array;

import java.util.*;

public class LeetCode1438_LongestSubArray {
    public static void main(String[] args) {
        int[] nums1 = {8,2,4,7};
        int limit1 = 4;
        int[] nums2 = {10,1,2,4,7,2};
        int limit2 = 5;
        int[] nums3 = {4,2,2,2,4,4,2,2};
        int limit3 = 0;
        int[] nums4 = {8};
        int limit4 = 10;
        int[] nums5 = {1,5,6,7,8,10,6,5,6};
        int limit5 = 4;
//        System.out.println(longestSubArray(nums1,limit1));
//        System.out.println(longestSubArray(nums2,limit2));
//        System.out.println(longestSubArray(nums3,limit3));
//        System.out.println(longestSubArray(nums4,limit4));
//        System.out.println(longestSubArray(nums5,limit5));

        System.out.println(longestSubArrayBetter(nums1,limit1));
        System.out.println(longestSubArrayBetter(nums2,limit2));
        System.out.println(longestSubArrayBetter(nums3,limit3));
        System.out.println(longestSubArrayBetter(nums4,limit4));
        System.out.println(longestSubArrayBetter(nums5,limit5));

        System.out.println(longestSubArrayDeque(nums1,limit1));
        System.out.println(longestSubArrayDeque(nums2,limit2));
        System.out.println(longestSubArrayDeque(nums3,limit3));
        System.out.println(longestSubArrayDeque(nums4,limit4));
        System.out.println(longestSubArrayDeque(nums5,limit5));
    }

    private static int longestSubArrayDeque(int[] nums, int limit) {
        Deque<Integer> maxHeap = new ArrayDeque<>();
        Deque<Integer> minHeap = new ArrayDeque<>();
        int i = 0, res = 0;
        for (int j = 0; j < nums.length; j++) {
            while (!maxHeap.isEmpty() && maxHeap.peekLast() < nums[j]) {
                maxHeap.pollLast();
            }
            while (!minHeap.isEmpty() && minHeap.peekLast() > nums[j]) {
                minHeap.pollLast();
            }
            maxHeap.add(nums[j]);
            minHeap.add(nums[j]);
            if (maxHeap.peekFirst() - minHeap.peekFirst() > limit) {
                if (maxHeap.peekFirst() == nums[i]) {
                    maxHeap.pollFirst();
                }
                if (minHeap.peekFirst() == nums[i]) {
                    minHeap.pollFirst();
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
    private static int longestSubArrayBetter(int[] nums, int limit){
        int n = nums.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparingInt(a->a[0])));
        int i = 0;
        int j = 0;
        int maxLength = 0;
        while (j<n){
            minHeap.add(new int[]{nums[j],j});
            maxHeap.add(new int[]{nums[j],j});
            while (Objects.requireNonNull(maxHeap.peek())[0] - Objects.requireNonNull(minHeap.peek())[0]>limit){
                i = Math.min(maxHeap.peek()[1],minHeap.peek()[1])+1;
                while ((minHeap.peek() != null ? minHeap.peek()[1] : 0) <i){
                    minHeap.poll();
                }
                while ((maxHeap.peek() != null ? maxHeap.peek()[1] : 0) <i){
                    maxHeap.poll();
                }
            }
            maxLength = Math.max(maxLength,j-i+1);
            j++;
        }
        return maxLength;
    }
    private static int longestSubArray(int[] nums, int limit) {
        int n = nums.length;
        int size = 0;
        for(int i =0;i<n;i++){
            int minSize = 1;
            int min = nums[i];
            int max = nums [i];
            for(int j =i+1;j<n;j++){
                if(Math.abs(min-nums[j])<=limit && Math.abs(max-nums[j])<=limit) {
                    minSize++;
                    min = Math.min(min, nums[j]);
                    max = Math.max(max, nums[j]);
                }
                else {
                    break;
                }
            }
            size = Math.max(size,minSize);
        }
        return size;
    }
}
