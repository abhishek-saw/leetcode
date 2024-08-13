package PriorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode703_KthLargestStream {
    public static void main(String[] args) {
        KthLargestHeap kthLargest = new KthLargestHeap(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
        System.out.println();
        KthLargestPQ kthLargest1 = new KthLargestPQ(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest1.add(3));
        System.out.println(kthLargest1.add(5));
        System.out.println(kthLargest1.add(10));
        System.out.println(kthLargest1.add(9));
        System.out.println(kthLargest1.add(4));

    }
    public static class KthLargestHeap {
       List<Integer> stream;
        int k;
        public KthLargestHeap(int k, int[] nums) {
            this.k = k;
            stream = new ArrayList<>(nums.length);
            for (int num: nums){
                stream.add(num);
            }
            Collections.sort(stream);
        }

        public int add(int val) {
            int index = getIndex(val);
            stream.add(index, val);
            return stream.get(stream.size()-k);
        }

        private int getIndex(int val) {
            int left = 0;
            int right = stream.size()-1;
            while (left<=right){
                int mid = left +(right-left)/2;
                int element = stream.get(mid);
                if(element==val){
                    return mid;
                }
                else if(element>val){
                    right = mid-1;
                }
                else {
                    left = mid+1;
                }
            }
            return left;
        }
    }

    public static class KthLargestPQ {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int size;
        public KthLargestPQ(int k, int[] nums) {
            for (int num :nums){
                priorityQueue.add(num);
            }
            size = k;
            while(priorityQueue.size()>k){
                priorityQueue.poll();
            }
        }

        public int add(int val) {
            priorityQueue.add(val);
            if(priorityQueue.size()>size){
                priorityQueue.poll();
            }
            return priorityQueue.element();
        }
    }
}
