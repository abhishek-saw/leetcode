package Array;

import java.util.HashMap;

public class LeetCode2441_FindMaxK {
    public static void main(String[] args) {
        int [] nums = {-1,10,6,7,-7,1};
        System.out.println(findMaxK(nums));
    }

    private static int findMaxK(int[] nums) {
        HashMap<Integer,Boolean> map = new HashMap<>();
        for(Integer integer:nums){
            map.put(integer,true);
        }
        int ans = -1;
        for(Integer integer:nums){
            if(map.containsKey(-integer)){
                if(ans<Math.abs(integer)){
                    ans = Math.abs(integer);
                }
            }
        }
        return ans;
    }
}
