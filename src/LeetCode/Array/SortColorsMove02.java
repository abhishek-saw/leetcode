package Array;

import java.util.Arrays;

public class SortColorsMove02 {
    public static void main(String[] args) {
        int[] nums  = {2,0,2,1,1,0};
        System.out.println(Arrays.toString(nums));
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void sortColors(int[] nums) {
        int zeroIndex = 0;
        for(int i = 0; i<nums.length;i++){
            if(nums[i]==0) {
                int temp = nums[i];
                nums[i] = nums[zeroIndex];
                nums[zeroIndex] = temp;
                zeroIndex++;
            }
        }

        int twoIndex = nums.length-1;
        for(int i = nums.length-1; i>=0;i--){
            if(nums[i]==2) {
                int temp = nums[i];
                nums[i] = nums[twoIndex];
                nums[twoIndex] = temp;
                twoIndex--;
            }
        }
    }
}
