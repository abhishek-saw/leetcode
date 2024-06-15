package PriorityQueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode502_IPO {
    public static void main(String[] args) {
        int k1 = 2;
        int w1 = 0;
        int [] profits1 = {1,2,3};
        int [] capital1 = {0,1,1};
        int k2 = 3;
        int w2 = 0;
        int [] profits2 = {1,2,3};
        int [] capital2 = {0,1,2};
        System.out.println(findMaximizedCapital(k1,w1,profits1,capital1));
        System.out.println(findMaximizedCapital(k2,w2,profits2,capital2));
        System.out.println(findMaximizedCapitalBetter(k1,w1,profits1,capital1));
        System.out.println(findMaximizedCapitalBetter(k2,w2,profits2,capital2));
    }

    private static int findMaximizedCapitalBetter(int k, int w, int[] profits, int[] capital) {
        int[][] business = new int[profits.length][2];
        for(int i =0;i<business.length;i++){
            business[i][0] = capital[i];
            business[i][1] = profits[i];
        }
        Arrays.sort(business, Comparator.comparingInt(a -> a[0]));
        System.out.println(Arrays.deepToString(business));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        while(k>0){
            while(i<profits.length && business[i][0]<=w){
                pq.offer(business[i][1]);
                i++;
            }
            if(pq.isEmpty()){
                return w;
            }
            w+=pq.remove();
            k--;
        }
        return w;
    }

    private static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparingInt(a->a[0])));
        PriorityQueue<int[]> pqHelper = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparingInt(a->a[0])));
        for(int i =0;i<profits.length;i++){
            pq.offer(new int[]{profits[i],capital[i]});
        }
        while(k>0 &&!pq.isEmpty()){
            int [] candidate = pq.peek();
            if(w>=candidate[1]){
                pq.poll();
                w+=candidate[0];
                k--;
                pq.addAll((pqHelper));
                pqHelper.clear();
            }
            else {
                pqHelper.offer(pq.poll());
            }
        }
        return w;
    }
}
