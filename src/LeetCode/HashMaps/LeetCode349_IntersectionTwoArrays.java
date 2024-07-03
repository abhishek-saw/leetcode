package HashMaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class LeetCode349_IntersectionTwoArrays {
    public static void main(String[] args) {
        int [] nums1 = {1,2,2,1};
        int [] nums2 = {2,2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return intersection(nums2,nums1);
        }
        HashSet<Integer> maps = new HashSet<>();
        for(int i : nums1){
            maps.add(i);
        }
        ArrayList<Integer> answer = new ArrayList<>();
        for (int j: nums2){
            if(maps.contains(j)){
                answer.add(j);
                maps.remove(j);
            }
        }
        int [] array = new int[answer.size()] ;
        for(int i = 0;i<answer.size();i++){
            array[i] = answer.get(i);
        }
        return array;
    }
}
