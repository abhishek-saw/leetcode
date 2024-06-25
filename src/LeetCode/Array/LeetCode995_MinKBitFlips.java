package Array;

public class LeetCode995_MinKBitFlips {
    public static void main(String[] args) {
        int[] nums1 = {0,1,0};
        int k1 = 1;
        int[] nums2 ={1,1,0};
        int k2 = 2;
        int[] nums3 = {0,0,0,1,0,1,1,0};
        int k3 = 3;
        System.out.println(minKBitFlips(nums1,k1));
        System.out.println(minKBitFlips(nums2,k2));
        System.out.println(minKBitFlips(nums3,k3));


    }

    private static int minKBitFlips(int[] nums, int k) {
        int n = nums.length, flipped = 0, res = 0;
        int[] isFlipped = new int[n];
        for (int i = 0; i < nums.length; ++i) {
            if (i >= k)
                flipped ^= isFlipped[i - k];
            if (flipped == nums[i]) {
                if (i + k > nums.length)
                    return -1;
                isFlipped[i] = 1;
                flipped ^= 1;
                res++;
            }
        }
        return res;
    }
}