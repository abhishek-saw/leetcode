package Array;

import java.util.*;

public class LeetCode1636_FrequencySort {
    public static void main(String[] args) {
        int[] num1 = {1,1,2,2,2,3};
        int[] num2 = {2,3,1,3,2};
        int[] num3 = {-1,1,-6,4,5,-6,1,4,1};
        System.out.println(Arrays.toString(frequencySort(num1)));
        System.out.println(Arrays.toString(frequencySort(num2)));
        System.out.println(Arrays.toString(frequencySort(num3)));
    }

    private static int[] frequencySort(int[] nums) {
        Integer[] numsObj = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsObj[i] = nums[i];
        }
        HashMap<Integer,Integer> freq = new HashMap<>();
        for (int i :numsObj){
            freq.put(i, freq.getOrDefault(i,0)+1);
        }
        Arrays.sort(numsObj,(a,b)-> {
            if (freq.get(a).equals(freq.get(b))) {
                return Integer.compare(b, a);
            }
            return Integer.compare(freq.get(a), freq.get(b));
        });
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numsObj[i];
        }
        return nums;
    }
}
