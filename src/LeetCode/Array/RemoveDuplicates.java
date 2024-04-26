package Array;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int [] nums = {1,1,2};
        System.out.println(Arrays.toString(nums));
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    private static int removeDuplicates(int[] nums) {
        if(nums.length==0 ){
            return 0;
        }
        int k = 1;
        int candidate = nums[0];
        for(int i =1;i<nums.length;i++){
            if(candidate==nums[i]){
                continue;
            }
            else {
                nums[k] = nums[i];
                candidate = nums[k];
                k++;
            }
        }
        return k;
    }
}
