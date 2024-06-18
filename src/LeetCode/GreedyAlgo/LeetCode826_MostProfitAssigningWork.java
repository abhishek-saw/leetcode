package GreedyAlgo;

import java.util.*;

public class LeetCode826_MostProfitAssigningWork {
    public static void main(String[] args) {
        int[] difficulty1 = {2,4,6,8,10};
        int[] profit1 = {10,20,30,40,50};
        int[] worker1 = {4,5,6,7};
        int[] difficulty2 = {85,47,57};
        int[] profit2 = {24,66,99};
        int[] worker2 = {40,25,25};
        int[] difficulty3 = {68,35,52,47,86};
        int[] profit3 = {67,17,1,81,3};
        int[] worker3 = {92,10,85,84,82};
        System.out.println(maxProfitAssignment(difficulty1,profit1,worker1));
        System.out.println(maxProfitAssignment(difficulty2,profit2,worker2));
        System.out.println(maxProfitAssignment(difficulty3,profit3,worker3));
        System.out.println(maxProfitAssignmentHeap(difficulty1,profit1,worker1));
        System.out.println(maxProfitAssignmentHeap(difficulty2,profit2,worker2));
        System.out.println(maxProfitAssignmentHeap(difficulty3,profit3,worker3));
        System.out.println(maxProfitAssignmentBinary(difficulty1,profit1,worker1));
        System.out.println(maxProfitAssignmentBinary(difficulty2,profit2,worker2));
        System.out.println(maxProfitAssignmentBinary(difficulty3,profit3,worker3));

    }
    private static int maxProfitAssignmentBinary(int[] difficulty, int[] profit, int[] worker){
        int diffLen = difficulty.length;
        int[][] diffProf = new int[diffLen][2];
        for(int index = 0; index < diffLen; index++){
            diffProf[index][0] = difficulty[index];
            diffProf[index][1] = profit[index];
        }
        Arrays.sort(diffProf, Comparator.comparingInt(a -> a[0]));
        int[] maxProfTill = new int[diffLen];
        for(int index = 0; index < diffLen; index++){
            maxProfTill[index] = Math.max(((index > 0) ? (maxProfTill[index-1]) : 0), diffProf[index][1]);
        }
        int totalProf = 0;

        for (int i : worker) {
            int maxDiffIndex = findMaxDiffJob(diffProf, i);
            if (maxDiffIndex != -1) {
                totalProf += maxProfTill[maxDiffIndex];
            }
        }
        return totalProf;
    }
    private static int findMaxDiffJob(int[][] diffProf, int workerCap){
        int left = 0, right = diffProf.length-1;
        int ansIndex = -1;
        while(left <= right){
            int midIndex = left + (right - left) / 2;
            if(workerCap >= diffProf[midIndex][0]){
                ansIndex = midIndex;
                left = midIndex + 1;
            }else{
                right = midIndex - 1;
            }
        }
        return ansIndex;
    }
    private static int maxProfitAssignmentHeap(int[] difficulty, int[] profit, int[] worker) {
        Queue<int[]> pq = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparingInt(a->a[0])));
        for (int i = 0; i < profit.length; i++) {
            pq.add(new int[]{difficulty[i],profit[i]});
        }
        Arrays.sort(worker);
        int profits = 0;
        int idx = worker.length-1;
        while (idx>=0 &&!pq.isEmpty()){
            if(pq.peek()[0]>worker[idx]){
                pq.remove();
            }
            else {
                profits+=pq.peek()[1];
                idx--;
            }
        }
        return profits;
    }
    private static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] work = new int[difficulty.length][2];
        for (int i = 0; i < profit.length; i++) {
            work[i][0] = difficulty[i];
            work[i][1] = profit[i];
        }
        Arrays.sort(work, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(worker);
        int profits = 0;
        int start = 0;
        int gain = 0;
        for (int w : worker) {
            while (start < difficulty.length && w >= work[start][0]) {
                gain = Math.max(gain, work[start][1]);
                start++;
            }
            profits += gain;
        }
        return profits;
    }
}
