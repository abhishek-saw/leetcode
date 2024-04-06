package PriorityQueue;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        Map<String ,String> map = new HashMap<>() {};
        map.put("1","2");
        map.put("11","2");
        map.put("111","2");
        map.put("1111","2");
        System.out.println(map);
        int[] arr = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(arr,k));
    }
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> integers = new PriorityQueue<>(Collections.reverseOrder());
        for(Integer integer:nums){
            integers.add(integer);
        }
        int m = 0;
        int ans = 0;
        while(m<k && integers.peek()!=null){
            ans = integers.poll();
            m++;
        }
        return ans;
    }
}
