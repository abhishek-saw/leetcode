package AllLeetCodeContest;

public class LeetCode3151_SpecialArrayI {
    public static void main(String[] args) {
        int [] nums1 = {1};
        int [] nums2 = {2,1,4};
        int [] nums3 = {4,3,1,6};
        System.out.println(isArraySpecial(nums1));
        System.out.println(isArraySpecial(nums2));
        System.out.println(isArraySpecial(nums3));


    }

    private static boolean isArraySpecial(int[] nums) {
        if(nums.length<=1){
            return true;
        }
        boolean candidate = nums[0] % 2 == 0;
        for(int i = 1;i< nums.length;i++){
            boolean smallAnswer;
            smallAnswer = nums[i] % 2 == 0;
            if(smallAnswer==candidate){
                return false;
            }
            candidate = smallAnswer;
        }
        return true;
    }
}