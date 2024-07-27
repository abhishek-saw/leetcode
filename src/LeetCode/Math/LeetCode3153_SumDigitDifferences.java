package Math;


public class LeetCode3153_SumDigitDifferences {
    public static void main(String[] args) {
        int[] nums1 = {13,23,12};
        int[] nums2 = {10,10,10,10};
        int[] nums3 = {50,28,48};
        System.out.println(sumDigitDifferences(nums1));
        System.out.println(sumDigitDifferences(nums2));
        System.out.println(sumDigitDifferences(nums3));
    }

    private static long sumDigitDifferences(int[] nums) {
        int digitLength = String.valueOf(nums[0]).length();
        long sumDiff = 0;
        for (int i = 0; i < digitLength; ++i) {
            int[] countDigits = new int[10];
            for (int j = 0; j < nums.length; ++j) {
                int currDigit = nums[j] % 10;
                nums[j] = nums[j] / 10;
                countDigits[currDigit]++;
                sumDiff += (j + 1) - countDigits[currDigit];
            }
        }
        return sumDiff;
    }
}