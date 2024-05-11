package PriorityQueue;


import java.util.*;

public class MinimumCostToHireKWorkers {
    public static void main(String[] args) {
        int[] quality = {10, 20, 5};
        int[] wage = {70, 50, 30};
        int k = 2;
        System.out.println("Minimum Cost To Hire K Workers:O[n(logn+logk)] " + minCostToHireWorkersBest(quality, wage, k));
        System.out.println("Minimum Cost To Hire K Workers:O[n(n+logk)] " + minCostToHireWorkersBruteForce(quality, wage, k));
        System.out.println("Minimum Cost To Hire K Workers:O[n(n+logk)] " + minCostToHireWorkersBruteForceTwo(quality, wage, k));
    }
    private static class Worker implements Comparable<Worker> {
        double ratio;
        int quality;
        Worker(double ratio, int quality) {
            this.ratio = ratio;
            this.quality = quality;
        }
        @Override
        public int compareTo(Worker other) {
            return Double.compare(this.ratio, other.ratio);
        }
    }
    private static double minCostToHireWorkersBest(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double minCost = Double.MAX_VALUE;
        List<Worker> workers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            workers.add(new Worker(wage[i] / (double) quality[i], quality[i]));
        }
        // Sorting workers by their wage-quality ratio
        Collections.sort(workers);
        // Max-heap for the qualities using a comparator
        PriorityQueue<Integer> highQualityWorkers = new PriorityQueue<>(Comparator.reverseOrder());
        double qualityTillNow = 0;
        for (Worker worker : workers) {
            double ratio = worker.ratio;
            int quails = worker.quality;
            qualityTillNow += quails;
            highQualityWorkers.add(quails);
            if (highQualityWorkers.size() > k) { // if PriorityQueue has more values than k then remove and subtract
                qualityTillNow -= highQualityWorkers.remove();
            }
            if (highQualityWorkers.size() == k) { // first time and for every time
                minCost = Math.min(minCost, qualityTillNow * ratio);
            }
        }
        return minCost;
    }
    private static double minCostToHireWorkersBruteForceTwo(int[] quality, int[] wage, int k) {
        double minCost = Double.MAX_VALUE;
        double[] ratio = new double[quality.length];
        for(int i =0;i< ratio.length;i++) {
            ratio[i] = (double) wage[i] / quality[i];
        }
        HashMap<Double,Integer> map = new HashMap<>();
        for(int i =0;i< ratio.length;i++) {
            map.put(ratio[i],quality[i]);
        }
        Arrays.sort(ratio);
        for(int manager = k-1;manager<quality.length;manager++){
            ArrayList<Double> group = new ArrayList<>();
            for(int j =0;j<=manager;j++){
                group.add(ratio[manager]*map.get(ratio[j]));
            }
            PriorityQueue<Double> pq = new PriorityQueue<>(group);
            double smallMinCost = 0;
            int count = 0;
            while (count<k) {
                smallMinCost += pq.remove();
                count++;
            }
            minCost = Math.min(minCost,smallMinCost);
        }
        return minCost;

    }
    public static double minCostToHireWorkersBruteForce(int[] quality, int[] wage, int k) {
        double minCost = Double.MAX_VALUE;
        for(int i =0;i< wage.length;i++){
            double ratio = (double)wage[i]/quality[i];
            ArrayList<Double> group = new ArrayList<>();
            for(int j =0;j<quality.length;j++){
                double wages = ratio*quality[j];
                if(wages>=wage[j]) {
                    group.add(wages);
                }
            }
            if(group.size()<k){
                continue;
            }
            PriorityQueue<Double> pq = new PriorityQueue<>(group);
            double smallMinCost = 0;
            int count = 0;
            while (count<k) {
                smallMinCost += pq.remove();
                count++;
            }
            minCost = Math.min(smallMinCost, minCost);
        }
        return minCost;
    }
}
