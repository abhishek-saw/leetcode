package Array;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1,-4};
        int[] nums2 = {1, 0, -1};
        int[] nums3 = {0,0,0,0};
        int[] nums4 = {3,0,-2,-1,1,2};
        List<List<Integer>> answer2 = threeSum(nums4);
        for (List<Integer> list : answer2) {
            System.out.println(list);
        }
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer= new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-1;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int j = i+1;
            int k = nums.length-1;
            while (j<k){
                int sums = nums[i]+nums[j]+nums[k];
                if(sums<0) {
                   j++;
                }
                else if(sums>0){
                    k--;
                }
                else {
                    List<Integer> ans = new ArrayList<>(List.of(nums[i],nums[j],nums[k]));
                    answer.add(ans);
                    j++;
                    k--;
                    while (j<k && nums[j]==nums[j-1]){
                        j++;
                    }
                    while (j<k && nums[j]==nums[k+1]){
                        k--;
                    }

                }
            }
        }
        return answer;
    }
    public static List<List<Integer>> threeSum1(int[] nums) {
        Set<List<Integer>> mapset = new HashSet<>();
        for(int i =0;i<nums.length;i++){
            HashMap<Integer,Integer> map= new HashMap<>();
            for(int j =i+1;j<nums.length;j++){
                if(map.containsKey(-(nums[i]+nums[j]))){
                    List<Integer> ans = new ArrayList<>();
                    ans.add(nums[i]);
                    ans.add(nums[j]);
                    ans.add(-(nums[i]+nums[j]));
                    Collections.sort(ans);
                    mapset.add(ans);
                }
                map.put(nums[j],1);
            }
        }
        return new ArrayList<>(mapset);
    }

}