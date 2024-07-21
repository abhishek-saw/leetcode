package Array;

import java.util.Arrays;

public class LeetCode2300_SuccessfulPairs {
    public static void main(String[] args) {
        int[] spells1 = {5, 1, 3};
        int[] potions1 = {1, 2, 3, 4, 5};
        int success1 = 7;
        int[] spells2 = {3, 1, 2};
        int[] potions2 = {8, 5, 8};
        int success2 = 16;
        System.out.println(Arrays.toString(successfulPairs(spells1, potions1, success1)));
        System.out.println(Arrays.toString(successfulPairs(spells2, potions2, success2)));

    }

    private static int[] successfulPairs(int[] spells, int[] potions, int success) {
        int s = spells.length;
        int p = potions.length;
        int[] pairs = new int[s];
        Arrays.sort(potions);
        for (int i = 0; i < s; i++) {
            int position = binarySearch(potions, spells[i], success);
            pairs[i] = p - position;
        }
        return pairs;
    }

    private static int binarySearch(int[] potions, int spell, long success) {
        int start = 0;
        int end = potions.length-1;
        int mid = 0;
        while (start <= end) {
            mid = start+(end-start)/2;
            if((long)potions[mid]*spell>=success){
                end = mid - 1;
            }
            else {
                start = mid+1;
            }
        }
        return start;
    }
}