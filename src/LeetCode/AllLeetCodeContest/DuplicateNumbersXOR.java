package AllLeetCodeContest;

import java.util.HashMap;

public class DuplicateNumbersXOR {
    public static void main(String[] args) {
        int [] nums1 = {1,2,1,3};
        int [] nums2 = {1,2,3};
        int [] nums3 = {1,2,2,1};
        System.out.println(duplicateNumbersXOR(nums1));
        System.out.println(duplicateNumbersXOR(nums2));
        System.out.println(duplicateNumbersXOR(nums3));
    }

    private static int duplicateNumbersXOR(int[] nums) {
        int answer = 0;
        HashMap<Integer,Integer> maps = new HashMap<>();
        for(Integer integer: nums){
            if(maps.containsKey(integer)){
                answer^=integer;
            }
            else {
                maps.put(integer,1);
            }
        }
        return answer;
    }
}
