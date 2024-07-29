package Array;

public class LeetCode334_IncreasingTripletSubsequence {
    public static void main(String[] args) {
        int[] nums1 = {2,5,3,4,1};
        int[] nums2 = {5,4,3,2,1};
        int[] nums3 = {2,1,5,0,4,6};
        System.out.println(increasingTriplet(nums1));
        System.out.println(increasingTriplet(nums2));
        System.out.println(increasingTriplet(nums3));
    }

    private static boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= a) {
                a = num;
            } else if (num <= b) {
                b = num;
            } else {
                return true;
            }
        }

        return false;
    }
}