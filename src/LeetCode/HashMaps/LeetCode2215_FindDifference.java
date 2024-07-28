package HashMaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode2215_FindDifference {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4,6};
        System.out.println(findDifference(nums1,nums2));
    }

    private static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> maps1 = new HashMap<>();
        HashMap<Integer,Integer> maps2 = new HashMap<>();
        for(int i : nums1){
            maps1.put(i,1);
        }
        for(int i:nums2){
                maps2.put(i,1);

        }
        List<Integer> curr1 = new ArrayList<>();
        for (int i: maps1.keySet()){
            if(!maps2.containsKey(i)){
                curr1.add(i);
            }

        }
        List<Integer> curr2 = new ArrayList<>();
        for (int i: maps2.keySet()){
            if(!maps1.containsKey(i)){
                curr2.add(i);
            }

        }
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(curr1);
        answer.add(curr2);
        return answer;
    }
}
