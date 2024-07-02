package DynamicProgramming;

public class LeetCode55_JumpGame {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};
        int[] nums3 = {2, 0, 0};
        System.out.println(canJump(nums1));
        System.out.println(canJump(nums2));
        System.out.println(canJump(nums3));
        System.out.println(canJumpMemo(nums1));
        System.out.println(canJumpMemo(nums2));
        System.out.println(canJumpMemo(nums3));
        System.out.println(canJumpDP(nums1));
        System.out.println(canJumpDP(nums2));
        System.out.println(canJumpDP(nums3));
    }

    private static boolean canJumpDP(int[] nums) {
        boolean [] dp = new boolean[nums.length+1];
        dp[0] = true;
        for(int i =1;i<dp.length-1;i++){
            for(int j =i-1;j>=0;j--){
                if(dp[j] && nums[j]+j>=i){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length-1];
    }

    private static boolean canJumpMemo(int[] nums) {
        boolean [] dp = new boolean[nums.length+1];
        return helper(nums,nums.length,0,dp);
    }

    private static boolean helper(int[] nums, int n, int index, boolean[] dp) {
        if(index>=n-1){
            return true;
        }
        if(dp[index]){
            return dp[index];
        }
        for(int i = 1;i<=nums[index];i++){
            dp[i] = helper(nums,n,i+index, dp);
            if(dp[i]){
                return true;
            }
        }
        return false;
    }


    private static boolean canJump(int[] nums) {
        int maxIndex = 0;
        for(int i =0;i<nums.length;i++){
            if(i>maxIndex) {
                return false;
            }
            maxIndex = Math.max(maxIndex,i+nums[i]);
            if(maxIndex>=nums.length) {
                return true;
            }
        }
        return true;
    }
}