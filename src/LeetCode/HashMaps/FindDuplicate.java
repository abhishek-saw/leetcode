package HashMaps;

import java.util.HashMap;

public class FindDuplicate {
    public static void main(String[] args) {
        int [] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }

    private static int findDuplicate(int[] nums) {
        HashMap<Integer,Integer> integerHashMap = new HashMap<>();
        for(Integer integer: nums){
            if(integerHashMap.containsKey(integer)){
                return integer;
            }
            else{
                integerHashMap.put(integer,1);
            }
        }
        return -1;
    }
}
