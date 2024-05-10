package PriorityQueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestPrimeFraction {
    public static void main(String[] args) {
        int [] arr = {1,2,3,5};
        int k = 3;
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(arr, k)));
        System.out.println(Arrays.toString(kthSmallestPrimeFraction2(arr, k)));

    }

    private static int [] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) ->arr[b.i]*arr[a.j]-(arr[a.i]*arr[b.j]));
        for(int i=0; i< arr.length - 1; i++){
            for(int j=i+1; j< arr.length; j++) {
                pq.add(new Pair(i,j));
                if(pq.size()>k){
                    pq.remove(pq.peek());
                }
            }
        }
        assert pq.peek() != null;
        return new int[]{arr[pq.peek().i],arr[pq.peek().j]};
    }
    public static class Pair {
        int i;
        int j;
        Pair(int i,int j){
            this.i = i;
            this.j = j;
        }
    }
    public static int[] kthSmallestPrimeFraction2(int[] arr, int k) {
        PriorityQueue<Pair2> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i< arr.length - 1; i++){
            for(int j=i+1; j< arr.length; j++) {
                double fraction = (double)arr[i]/ arr[j];
                pq.add(new Pair2(fraction, arr[i], arr[j]));
                if(pq.size()>k){
                    pq.remove(pq.peek());
                }
            }
        }
        assert pq.peek() != null;
        return new int[]{pq.peek().num,pq.peek().deno};
    }
    public static class Pair2 implements Comparable<Pair2> {
        double fraction;
        int num;
        int deno;
        Pair2(double fraction,int num,int deno){
            this.fraction = fraction;
            this.num = num;
            this.deno = deno;
        }
        public int compareTo(Pair2 pairs) {
            if (this.fraction > pairs.fraction) {
                return 1;
            }
            return -1;
        }
    }
}
