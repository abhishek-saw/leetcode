package AllLeetCodeContest;

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode3159_OccurrencesOfElement {
    public static void main(String[] args) {
        int[] nums1 = {1,3,1,7};
        int[] queries1 = {1,3,2,4};
        int x1 = 1;
        int[] nums2 = {1,2,3};
        int[] queries2 = {10};
        int x2 = 5;
        int[] nums3 = {1,4,3,3,6,4,8,3,10};
        int[] queries3 = {1,2,1,1,1,1,2,2,1,1};
        int x3 = 7;
        System.out.println(Arrays.toString(occurrencesOfElement(nums1, queries1, x1)));
        System.out.println(Arrays.toString(occurrencesOfElement(nums2, queries2, x2)));
        System.out.println(Arrays.toString(occurrencesOfElement(nums3, queries3, x3)));

    }

    private static int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int [] answer= new int[queries.length];
        HashMap<Integer,Integer> maps = new HashMap<>();
        int count = 1;
       for(int i = 0;i<nums.length;i++){
           if(nums[i]==x){
               maps.put(count,i);
               count++;
           }
       }
       for(int i = 0;i<queries.length;i++){
           answer[i] = maps.getOrDefault(queries[i], -1);
       }
        return answer;
    }
}
