package DynamicProgramming;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(rob(nums));
    }

    private static int rob(int[] nums) {
        return robHelper(nums);
    }

    private static int robHelper(int[] nums) {
        int [] dp = new int[nums.length+1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int m = 2;m<dp.length-1;m++) {
            int a = nums[m] + dp[m -2];
            int b = dp[m - 1];
            dp[m] = Math.max(a,b);
        }
        return dp[nums.length-1];
    }
}
