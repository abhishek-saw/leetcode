package Array;

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode1460_CanBeEqual {
    public static void main(String[] args) {
        int[] target1 = {1,2,3,4};
        int[] arr1 = {2,4,1,3};
        int[] target2 = {7};
        int[] arr2 = {7};
        int[] target3 = {3,7,9};
        int[] arr3 = {3,7,11};
        System.out.println(canBeEqual(target1,arr1));
        System.out.println(canBeEqual(target2,arr2));
        System.out.println(canBeEqual(target3,arr3));
        System.out.println(canBeEqualSort(target1,arr1));
        System.out.println(canBeEqualSort(target2,arr2));
        System.out.println(canBeEqualSort(target3,arr3));
    }

    private static boolean canBeEqualSort(int[] target, int[] arr) {
        int n=target.length;
        Arrays.sort(target);
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            if(target[i]!=arr[i]) return false;
        }
        return true;
    }

    private static boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer,Integer> mapsTarget = new HashMap<>();
        for(int i :target){
            mapsTarget.put(i,mapsTarget.getOrDefault(i,0)+1);
        }
        for(int i :arr) {
            if (mapsTarget.containsKey(i)) {
                if (mapsTarget.get(i) == 1) {
                    mapsTarget.remove(i);
                } else {
                    mapsTarget.put(i, mapsTarget.get(i) - 1);
                }
            }
        }
        return mapsTarget.isEmpty();
    }
}
