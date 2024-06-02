package HashMaps;

import java.util.HashMap;

public class LeetCode41_FirstMissingPositive {
    public static void main(String[] args) {
        int []  nums = {1,2,3,10,2147483647,9};
        System.out.println(firstMissingPositive(nums));
        System.out.println(firstMissingPositiveBetter(nums));

    }
    private static int firstMissingPositive(int[] nums) {
        int max = 0;
        HashMap<Integer,Boolean> map = new HashMap<>();
        for(Integer integer:nums){
            if(integer>max){
                max = integer;
            }
            map.put(integer,true);
        }
        System.out.println(map);
        for(int i =1;i<max;i++){
            if(!map.containsKey(i)){
                return i;
            }
        }
        return max+1;
    }
    private static int firstMissingPositiveBetter(int[] nums) {
        int i = 0;
        int n = nums.length;
        while(i<n){
            int correctIndex = nums[i]-1;
            if(nums[i]>0 && nums[i]<=n && nums[i] != nums[correctIndex] ){
                swap(nums,i,correctIndex);
            }
            else {
                i++;
            }
        }

        for(int j= 0;j<nums.length;j++){
            if(nums[j] != j+1){
                return j+1;
            }
        }
        return n+1;
    }

    private static void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}
