package HashMaps;

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode2418_SortPeople {
    public static void main(String[] args) {
        String[] names1 = {"Mary","John","Emma"};
        int[] heights1 = {180,165,170};
        String[] names2 = {"Alice","Bob","Bob"};
        int[] heights2 = {155,185,150};
        System.out.println(Arrays.toString(names1));
        System.out.println(Arrays.toString(sortPeople(names1, heights1)));
        System.out.println(Arrays.toString(names2));
        System.out.println(Arrays.toString(sortPeople(names2, heights2)));
    }

    private static String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer,String> hashMap = new HashMap<>();
        int n = heights.length;
        for(int i=0;i<n;i++){
            hashMap.put(heights[i],names[i]);
        }
        Arrays.sort(heights);
        names = new String[n];
        for(int i =n-1;i>=0;i--){
            names[n-i-1] = hashMap.get(heights[i]);
        }
        return names;
    }
}
