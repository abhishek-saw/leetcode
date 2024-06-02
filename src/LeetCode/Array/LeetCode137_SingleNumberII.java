package Array;

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode137_SingleNumberII {
    public static void main(String[] args) {
        int [] array1 = {2,2,3,2};
        int [] array2 = {0,1,0,1,0,1,99};
        System.out.println(singleNumberBitwise(array1));
        System.out.println(singleNumberBitwise(array2));
        System.out.println(singleNumber(array1));
        System.out.println(singleNumber(array2));
        System.out.println(singleNumberBit(array1));
        System.out.println(singleNumberBit(array2));
        System.out.println(singleNumberSort(array1));
        System.out.println(singleNumberSort(array2));

    }

    private static int singleNumberBitwise(int[] nums) {
        int ones = 0;
        int twos = 0;
        for(Integer num:nums){
            ones  = (ones^num)&~twos;
            twos  = (twos^num)&~ones;
        }
        return ones;
    }

    private static int singleNumberSort(int[] nums) {
        Arrays.sort(nums);
        int answer = 0;
        for(int i = 1;i<nums.length;i+=3){
            if(nums[i-1]!=nums[i]){
                answer = nums[i-1];
            }
        }
        return answer!=0? answer: nums[nums.length-1];
    }

    private static int singleNumberBit(int[] nums) {
        int answer =0;
        for (int i =0;i<32;i++){
            int count =0;
            for (int num : nums) {
                count += num >> i & 1;
            }
            if(count%3!=0){
                answer |=(1<<i);
            }
        }
        return answer;
    }

    private static int singleNumber(int[] nums) {
        HashMap<Integer,Integer> maps = new HashMap<>();
        for(Integer integer: nums){
            if(maps.containsKey(integer)){
                if(maps.get(integer)==2){
                    maps.remove(integer);
                }
                else {
                    maps.put(integer,maps.get(integer)+1);
                }
            }
            else {
                maps.put(integer,1);
            }
        }
        return (int) maps.keySet().toArray()[0];
    }
}
