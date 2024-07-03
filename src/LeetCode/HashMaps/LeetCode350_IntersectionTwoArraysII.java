package HashMaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LeetCode350_IntersectionTwoArraysII {
    public static void main(String[] args) {
        int [] nums1 = {1,2,2,1};
        int [] nums2 = {2,2};
        int [] nums3 = {4,9,5};
        int [] nums4 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
        System.out.println(Arrays.toString(intersection(nums3, nums4)));
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersection(nums2, nums1);
        }
        HashMap<Integer, Integer> maps = new HashMap<>();
        for (int i : nums1) {
            maps.put(i, maps.getOrDefault(i, 0) + 1);
        }
        ArrayList<Integer> answer = new ArrayList<>();
        for (int j : nums2) {
            if (maps.containsKey(j)) {
                answer.add(j);
                if (maps.get(j) == 1) {
                    maps.remove(j);
                } else {
                    maps.put(j, maps.get(j) - 1);
                }
            }
        }
        int[] array = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            array[i] = answer.get(i);
        }
        return array;
    }
}
