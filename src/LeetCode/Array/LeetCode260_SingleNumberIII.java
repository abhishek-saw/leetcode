package Array;

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode260_SingleNumberIII {
    public static void main(String[] args) {
        int [] array = {1,2,1,3,2,5};
        System.out.println(Arrays.toString(singleNumber(array)));
        System.out.println(Arrays.toString(singleNumberBitwise(array)));

    }

    private static int[] singleNumberBitwise(int[] nums) {
        int xor = 0;
        for(Integer num: nums){
            xor^=num;
        }
        int xor_a = 0;
        int xor_b = 0;
        
        int xor_pos = 0;
        while (((xor >> xor_pos) & 1) != 1) {
            xor_pos++;
        }
        for (int num : nums) {
            if (((num >> xor_pos) & 1) == 1) {
                xor_a^= num;
            } else {
                xor_b ^= num;
            }
        }

        return new int[]{xor_a,xor_b};
    }

    private static int[] singleNumber(int[] nums) {
        HashMap<Integer,Integer> maps = new HashMap<>();
        for(Integer integer: nums){
            if(maps.containsKey(integer)) {
                maps.remove(integer);
            }
            else {
                maps.put(integer,1);
            }
        }
        return new int[]{(int) maps.keySet().toArray()[0],(int) maps.keySet().toArray()[1]};
    }

}
