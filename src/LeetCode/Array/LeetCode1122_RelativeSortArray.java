package Array;

import java.util.*;

public class LeetCode1122_RelativeSortArray {
    public static void main(String[] args) {
        // T.C : O(N*LOGN)
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        int[] arr11 = {28,6,22,8,44,17};
        int[] arr22 = {22,28,8,6};
        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
        System.out.println(Arrays.toString(relativeSortArray(arr11, arr22)));
        //Lambda sort
        System.out.println(Arrays.toString(relativeSortArrayBetter(arr1, arr2)));
        System.out.println(Arrays.toString(relativeSortArrayBetter(arr11, arr22)));
    }

    private static int[] relativeSortArrayBetter(int[] arr1, int[] arr2) {
        Map<Integer,Integer> maps = new TreeMap<>();
        for (int i = 0;i<arr2.length;i++) {
            maps.put(arr2[i], i);
        }
        int largeValue = 1000000000; // 1e9 equivalent in Java
        for (int nums : arr1) {
            if (!maps.containsKey(nums)) {
                maps.put(nums, largeValue);
            }
        }
        List<Integer> arrayList = new ArrayList<>();
        for(int num : arr1){
            arrayList.add(num);
        }

        Comparator<Integer> comparator = (num1,num2)->{
            int index1 = maps.get(num1);
            int index2 = maps.get(num2);
            if (index1 == index2) {
                return Integer.compare(num1, num2);
            }
            return Integer.compare(index1, index2);
        };
        arrayList.sort(comparator);

        int[] sortedArray = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            sortedArray[i] = arrayList.get(i);
        }
        return sortedArray;
    }
    private static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> maps = new TreeMap<>();
        for (int nums : arr1) {
            maps.put(nums, maps.getOrDefault(nums, 0) + 1);
        }
        int index = 0;
        for (int k : arr2) {
            int count = maps.get(k);
            maps.remove(k);
            for (int j = 1; j <= count; j++) {
                arr1[index] = k;
                index++;
            }
        }
        while (!maps.isEmpty()){
            int nums =  maps.keySet().iterator().next();
            int count =  maps.get(nums);
            maps.remove(nums);
            for(int j = 1;j<=count;j++){
                arr1[index] = nums;
                index++;
            }
        }
        return arr1;
    }
}
