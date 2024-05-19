package Array;

import java.util.Arrays;
import java.util.Collections;

public class MaximumSumOfNodeValues {
    public static void main(String[] args) {
        int [] nums = {1,2,1};
        int k = 3;
        int [][] edges = {{0,1},{0,2}};
        System.out.println(maximumValueSum1(nums,k,edges));
        System.out.println(maximumValueSum2(nums,k,edges));
    }

    private static long maximumValueSum1(int[] nums, int k, int[][] edges) {
        long sum = 0;
        Integer [] gain = new  Integer[nums.length];
        for (int i =0;i<nums.length;i++){
            sum+=nums[i];
            gain[i] = (nums[i]^k) - nums[i];
        }
        Arrays.sort(gain, Collections.reverseOrder());
        for(int i = 0;i<gain.length;i+=2){
            int pairSum = gain[i] + gain[i+1];
            if(pairSum>0){
                return sum+pairSum;
            }
        }
        return sum;
    }
    private static long maximumValueSum2(int[] nums, int k, int[][] edges) {
        long sum = 0;
        int count = 0;
        long minLoss = Long.MAX_VALUE;
        for (long number : nums){
            if((number^k)>number){
                count++;
                sum+=(number^k);
            }
            else {
                sum+=number;
            }
            minLoss = Math.min(minLoss,Math.abs(number-(number^k)));
        }
        return count%2 == 0 ? sum : sum-minLoss;
    }
}
