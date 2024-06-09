package PriorityQueue;

import java.util.*;

public class LeetCode373_KSmallestPairs {
    public static void main(String[] args) {
        int[] num1 = {1, 7, 11};
        int[] num2 = {2, 4, 6};
        int k = 3;
        System.out.println(kSmallestPairs(num1, num2, k));
        System.out.println(kSmallestPairsBetter(num1, num2, k));
    }

    private static List<List<Integer>> kSmallestPairsBetter(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0] + a[1]));
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < nums1.length && i < k; i++) {
            priorityQueue.add(new int[]{nums1[i], nums2[0], 0});
        }
        while (k>0 && !priorityQueue.isEmpty()){
            int[] currentElement = priorityQueue.remove();
            answer.add(new ArrayList<>(List.of(currentElement[0],currentElement[1])));
            int currentIndex = currentElement[2];
            if(currentIndex+1<nums2.length){
                priorityQueue.add(new int[]{currentElement[0], nums2[currentIndex+1], currentIndex+1});
            }
            k--;
        }
        return answer;
    }

    private static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((b, a) -> ((a.get(0) + a.get(1)) - (b.get(0) + b.get(1))));
        List<List<Integer>> answer = new ArrayList<>();
        for (int value1 : nums1) {
            for (int value2 : nums2) {
                pq.add(new ArrayList<>(List.of(value1, value2)));
                if (pq.size() > k) {
                    pq.remove();
                }
            }
        }
        while (k>0 && !pq.isEmpty()){
            answer.add(pq.remove());
        }
        return answer;
    }
}
