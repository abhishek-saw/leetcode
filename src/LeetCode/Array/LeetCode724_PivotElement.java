package Array;

public class LeetCode724_PivotElement {
    public static void main(String[] args) {
        int [] nums = {1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));
    }
    private static int pivotIndex(int[] nums) {
        int rightSum = 0;
        for(Integer integer:nums) {
            rightSum += integer;
        }
        int leftSum = 0;
        for (int i=0;i<nums.length;i++){
            rightSum-=nums[i];
            if (leftSum==rightSum){
                return i;
            }
            leftSum+=nums[i];
        }
        return -1;
    }
}
