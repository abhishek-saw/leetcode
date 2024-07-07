package PriorityQueue;

import java.util.*;

public class LeetCode347_TopKFrequent {
    public static void main(String[] args) {
        int[] nums1 = {7,7,7,9,9,5,2,2,2,2,2,4,4,4,3,3,4,};
        int k1 = 2;
        int[] nums2 = {1};
        int k2 = 1;
        System.out.println(Arrays.toString(topKFrequent(nums1, k1)));
        System.out.println(Arrays.toString(topKFrequent(nums2, k2)));
    }

    private static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i : nums){
            hashMap.put(i, hashMap.getOrDefault(i,0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparingInt(a -> a[1])));
        for (int i : hashMap.keySet()){
            pq.add(new int[]{i,hashMap.get(i)});
        }
        int [] answer = new int[k];
        int index = 0;
        while (index<k){
            answer[index] = Objects.requireNonNull(pq.poll())[0];
            index++;
        }
        return answer;
    }
}
