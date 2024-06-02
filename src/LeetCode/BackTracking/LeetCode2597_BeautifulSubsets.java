package BackTracking;

import java.util.*;

public class LeetCode2597_BeautifulSubsets {
    static int beautifulSubset = 0;
//    private static Map<Integer, Integer> visited;

    public static void main(String[] args) {
        int [] nums1 = {4,2,6};
        int k1 = 2;
        int [] nums2 = {1};
        int k2 = 1;
        int [] nums3 = {1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000};
        int k3 = 1;
        System.out.println(beautifulSubsets(nums1,k1));
        beautifulSubset = 0;
        System.out.println(beautifulSubsets(nums2,k2));
        beautifulSubset = 0;
        System.out.println(beautifulSubsets(nums3,k3));
        System.out.println(beautifulSubsets1(nums1,k1));
        System.out.println(beautifulSubsets1(nums2,k2));
        System.out.println(beautifulSubsets1(nums3,k3));
    }
    private static int beautifulSubsets(int[] nums, int k){
        Map<Integer, Integer> visited = new HashMap<>();
        backtrackingSubsets(nums,0, k, visited);
        return beautifulSubset-1;
    }

    private static void backtrackingSubsets(int[] nums, int index, int k, Map<Integer, Integer> visited) {
        if(index==nums.length){
            beautifulSubset++;
            return;
        }
        int candidate = nums[index];
        if(!visited.containsKey(candidate+k) && !visited.containsKey(candidate-k)){
            visited.put(candidate, visited.getOrDefault(candidate, 0) + 1);
            backtrackingSubsets(nums,index+1, k, visited);
            visited.put(candidate,visited.get(candidate)-1);
            if(visited.get(candidate)==0){
                visited.remove(candidate);
            }
        }
        backtrackingSubsets(nums,index+1, k, visited);
    }
    private static int beautifulSubsets1(int[] nums, int k) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        backtrackingSubsets1(nums,0,k,new ArrayList<>(),subsets);
//        System.out.println(subsets);
        return subsets.size()-1;
    }
    private static void backtrackingSubsets1(int[] nums, int index, int k, List<Integer> currList, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(currList));
        for(int i =index;i<nums.length;i++) {
            boolean isBeautiful = false;
            for(Integer integer: currList){
                if(Math.abs(nums[i]-integer)==k){
                    isBeautiful =true;
                    break;
                }
            }
            if(!isBeautiful) {
                currList.add(nums[i]);
                backtrackingSubsets1(nums, i + 1, k, currList, subsets);
                currList.remove(currList.size() - 1);
            }
        }
    }
}
