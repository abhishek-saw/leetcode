package Array;

import java.util.HashSet;

public class LeetCode217_ContainsDuplicate {
    public static void main(String[] args) {
        int [] nums = {1,2,3,1};
        System.out.println(containsDuplicate(nums));
    }

    private static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> map = new HashSet<>();
        for (int num : nums) {
            if (map.contains(num)) {
                return true;
            }
            map.add(num);
        }
        return false;
    }
}