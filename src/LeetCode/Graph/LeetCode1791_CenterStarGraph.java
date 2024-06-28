package Graph;

import java.util.HashMap;

public class LeetCode1791_CenterStarGraph {
    public static void main(String[] args) {
        int[][] edges1 = {{1,2},{2,3},{4,2}};
        int[][] edges2 = {{1,2},{5,1},{1,3},{1,4}};
        System.out.println(findCenter(edges1));
        System.out.println(findCenter(edges2));
        System.out.println(findCenterMap(edges1));
        System.out.println(findCenterMap(edges2));
    }

    private static int findCenterMap(int[][] edges) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int[] edge : edges){
            hashMap.put(edge[0], hashMap.getOrDefault(edge[0],0)+1);
            hashMap.put(edge[1], hashMap.getOrDefault(edge[1],0)+1);
        }
        for(int star : hashMap.keySet()){
            if(hashMap.get(star)==edges.length){
                return star;
            }
        }
        return -1;
    }

    private static int findCenter(int[][] edges) {
        int [] e1 = edges[0];
        int [] e2 = edges[1];
        if(e1[0]==e2[0]){
            return e1[0];
        }
        else if(e1[0]==e2[1]){
            return e1[0];
        }
        return e1[1];
    }
}
