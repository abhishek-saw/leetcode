package Array;

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode2191_SortJumbled {
    public static void main(String[] args) {
        int [] mapping1 = {8,9,4,0,2,1,3,5,7,6};
        int [] nums1 = {991,338,38};
        int [] mapping2 = {0,1,2,3,4,5,6,7,8,9};
        int [] nums2 = {789,456,123};
        int [] mapping3 = {9,8,7,6,5,4,3,2,1,0};
        int [] nums3 = {0,1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(sortJumbled(mapping1, nums1)));
        System.out.println(Arrays.toString(sortJumbled(mapping2, nums2)));
        System.out.println(Arrays.toString(sortJumbled(mapping3, nums3)));
    }

    private static int[] sortJumbled(int[] mapping, int[] nums) {
        HashMap<Integer, Integer[]> freq = new HashMap<>();
        Integer[] numObj = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int number = jumbled(nums[i], mapping);
            if(!freq.containsKey(nums[i])){
                freq.put(nums[i], new Integer[]{number,i});
            }
            numObj[i] = nums[i];
        }

        Arrays.sort(numObj, (a, b) -> {
            if (freq.get(a)[0].equals(freq.get(b)[0])) {
                return Integer.compare(freq.get(a)[1], freq.get(b)[1]);
            }
            return Integer.compare(freq.get(a)[0], freq.get(b)[0]);

        });
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numObj[i];
        }
        return nums;
    }

    private static int jumbled(int num, int[] mapping) {
        if(num==0){
            return mapping[num];
        }
        int newNum = 0;
        int pow = 0;
        while (num > 0) {
            newNum = (int) (newNum + mapping[num % 10] * Math.pow(10, pow));
            pow++;
            num = num / 10;
        }
        return newNum;
    }
}
