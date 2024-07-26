package DynamicProgramming;

public class LeetCode45_JumpGameII {

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {4, 1, 1, 3, 1, 1, 1};
        int[] nums3 = {0};
        int[] nums4 = {2, 3, 0, 1, 4};
        int[] nums5 = {5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5};
        System.out.println(jumps(nums1));
        System.out.println(jumps(nums2));
        System.out.println(jumps(nums3));
        System.out.println(jumps(nums4));
        System.out.println(jumps(nums5));
    }

    public static int jumps(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int jumps = 0, currentEnd = 0, farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
            System.out.println("farthest : "+farthest + " i :" + i + " currentEnd : " + currentEnd + " jumps : " + jumps  );
        }
        return jumps;
    }
}

