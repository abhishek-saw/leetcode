package Array;

public class LeetCode485_FindMaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums1 = {1,1,0,1,1,1};
        int[] nums2 = {1,0,1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(nums1));
        System.out.println(findMaxConsecutiveOnes(nums2));
    }

    private static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int ct = 0;
        for (int num : nums) {
            if (num == 1) {
                ct++;
            } else {
                ct = 0;
            }
            count = Math.max(count, ct);
        }
        return count;
    }
}
