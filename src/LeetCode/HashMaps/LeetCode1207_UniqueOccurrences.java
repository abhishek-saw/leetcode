package HashMaps;

import java.util.HashMap;

public class LeetCode1207_UniqueOccurrences {
    public static void main(String[] args) {
        int[] arr1 = {1,2,2,1,1,3};
        int[] arr2 = {1,2};
        int[] arr3 = {-3,0,1,-3,1,1,1,-3,10,0};
        System.out.println(uniqueOccurrences(arr1));
        System.out.println(uniqueOccurrences(arr2));
        System.out.println(uniqueOccurrences(arr3));
    }

    private static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> maps = new HashMap<>();
        for(int i :  arr){
            maps.put(i, maps.getOrDefault(i,0)+1);
        }
        HashMap<Integer,Integer> occ =  new HashMap<>();
        for(int key : maps.keySet()){
            if(occ.containsKey(maps.get(key))){
                return false;
            }
            occ.put(maps.get(key),1);
        }
        return true;
    }
}
