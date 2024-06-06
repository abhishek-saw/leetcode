package HashMaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LeetCode1296_IsPossibleDivide {
    public static void main(String[] args) {
        int [] nums1 = {1,2,3,6,2,3,4,7,8};
        int k1 = 3;
        int [] nums2 = {1,2,3,4,5};
        int k2 = 4;
        int [] nums3 = {8,8,9,7,7,7,6,7,10,6};
        int k3 = 2;
        int [] nums4 = {9,13,15,23,22,25,4,4,29,15,8,23,12,19,24,17,18,11,22,24,17,17,10,23,21,18,14,18,7,6,3,6,19,11,16,11,12,13,8,26,17,20,13,19,22,21,27,9,20,15,20,27,8,13,25,23,22,15,9,14,20,10,6,5,14,12,7,16,21,18,21,24,23,10,21,16,18,16,18,5,20,19,20,10,14,26,2,9,19,12,28,17,5,7,25,22,16,17,21,11};
        int k4 = 10;
        System.out.println(isPossibleDivide(nums1,k1));
        System.out.println(isPossibleDivide(nums2,k2));
        System.out.println(isPossibleDivide(nums3,k3));
        System.out.println(isPossibleDivide(nums4,k4));
        System.out.println();
        System.out.println(isPossibleDivideBetter(nums1,k1));
        System.out.println(isPossibleDivideBetter(nums2,k2));
        System.out.println(isPossibleDivideBetter(nums3,k3));
        System.out.println(isPossibleDivideBetter(nums4,k4));
    }

    private static boolean isPossibleDivideBetter(int[] nums, int k) {
        int numsSize = nums.length;
        if(numsSize%k!=0){
            return false;
        }
        Map<Integer, Integer> cardFreq = new TreeMap<>();
        for (int cards : nums) {
            cardFreq.put(cards, cardFreq.getOrDefault(cards, 0) + 1);
        }
        System.out.println(cardFreq);
        while (!cardFreq.isEmpty()){
            int current_card = cardFreq.entrySet().iterator().next().getKey();
            for (int i = 0; i < k; i++) {
                if (!cardFreq.containsKey(current_card + i)) {
                    return false;
                }
                cardFreq.put(current_card + i, cardFreq.get(current_card + i) - 1);
                if (cardFreq.get(current_card + i) == 0) {
                    cardFreq.remove(current_card + i);
                }
            }
        }
        return true;
}

    private static boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length%k!=0){
            return false;
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        HashMap<Integer,Integer> maps = new HashMap<>();
        for (Integer num : nums) {
            if (maps.containsKey(num)) {
                maps.put(num, maps.get(num) + 1);
                continue;
            }
            maps.put(num, 1);
        }
        System.out.println(maps);
        int index =0;
        while (!maps.isEmpty()){
            int num = nums[index];
            if(maps.containsKey(num)) {
                if(maps.get(num)==1) {
                    maps.remove(num);
                }
                else {
                    maps.put(num,maps.get(num)-1);
                }
                for (int j = 1; j < k; j++) {
                    if(maps.containsKey(num+j)){
                        if(maps.get(num+j)==1) {
                            maps.remove(num+j);
                            index++;
                        }
                        else {
                            maps.put(num+j,maps.get(num+j)-1);
                        }
                    }
                    else {
                        return false;
                    }
                }
            }
            else{
                index++;
            }
        }
        return true;
    }
}
