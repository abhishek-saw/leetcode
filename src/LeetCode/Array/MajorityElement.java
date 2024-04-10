package Array;

import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        int [] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElementBetter(nums));

    }

    private static int majorityElement(int[] nums) {
        HashMap<Integer,Integer> maps = new HashMap<>();
        for(Integer integer:nums){
            if(maps.containsKey(integer)){
                maps.put(integer,maps.get(integer)+1);
            }
            else {
                maps.put(integer,1);
            }
        }
        int majorityElement = 0;
        int maxCount = 0;
        for (int num : nums) {
            int j = maps.get(num);
            if (maps.get(num) > maxCount) {
                maxCount = maps.get(num);
                majorityElement = num;
            }
        }
        System.out.println(maps);
        return majorityElement;
    }
    private static int majorityElementBetter(int[] nums){
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
