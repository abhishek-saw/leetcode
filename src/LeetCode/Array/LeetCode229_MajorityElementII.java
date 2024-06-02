package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode229_MajorityElementII {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElementBetter(nums));
    }

    private static List<Integer> majorityElementBetter(int[] nums) {
        int candidate1 = -1;
        int candidate2 = -1;
        int count1 = 0;
        int count2 = 0;
        for (int integer : nums) {
            if (count1 == 0 && integer != candidate2) {
                count1++;
                candidate1 = integer;
            } else if (count2 == 0 && integer != candidate1) {
                count2++;
                candidate2 = integer;
            } else if (integer == candidate1) {
                count1++;
            } else if (integer == candidate2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int integer : nums){
            if(integer==candidate1){
                count1++;
            }
            else if(integer==candidate2){
                count2++;
            }
        }
        List<Integer> answer = new ArrayList<>();
        if (count1>nums.length/3){
            answer.add(candidate1);
        }
        if (count2>nums.length/3){
            answer.add(candidate2);
        }
        return answer;
    }

    private static List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> maps = new HashMap<>();
        for(Integer integer:nums){
            if(maps.containsKey(integer)){
                maps.put(integer,maps.get(integer)+1);
            }
            else {
                maps.put(integer,1);
            }
        }
        System.out.println(maps);
        double count = (double) nums.length /3;
        List<Integer> answer = new ArrayList<>();
        for(Integer integer:nums){
            if(maps.get(integer)>count){
                answer.add(integer);
                maps.put(integer,0);
            }
        }
        return answer;
    }
}