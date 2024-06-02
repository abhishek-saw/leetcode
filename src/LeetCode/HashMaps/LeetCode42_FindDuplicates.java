package HashMaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode42_FindDuplicates {
    public static void main(String[] args) {
        int [] nums = {4,3,2,7,8,2,3,1};
        int [] nums1 = {1,2,3,4,5,6,7,8};
        System.out.println(findDuplicates(nums));
        System.out.println(findDuplicates(nums1));
        System.out.println(findDuplicatesBetter(nums));
        System.out.println(findDuplicatesBetter(nums1));
    }

    private static List<Integer> findDuplicatesBetter(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int x = Math.abs(nums[i]);
            if (nums[x - 1] < 0) {
                answer.add(x);
            }
            nums[x - 1] *= -1;
        }
        return answer;
    }
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (Integer integer : nums) {
            if (hashMap.containsKey(integer)) {
                answer.add(integer);
            } else {
                hashMap.put(integer, 1);
            }

        }
        return answer;
    }
}
