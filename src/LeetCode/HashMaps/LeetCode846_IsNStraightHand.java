package HashMaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LeetCode846_IsNStraightHand {
    public static void main(String[] args) {
        int [] hand1 = {1,2,3,6,2,3,4,7,8};
        int groupSize1 = 3;
        int [] hand2 = {1,2,3,4,5};
        int groupSize2 = 4;
        int [] hand3 = {8,8,9,7,7,7,6,7,10,6};
        int groupSize3 = 2;
        int [] hand4 = {9,13,15,23,22,25,4,4,29,15,8,23,12,19,24,17,18,11,22,24,17,17,10,23,21,18,14,18,7,6,3,6,19,11,16,11,12,13,8,26,17,20,13,19,22,21,27,9,20,15,20,27,8,13,25,23,22,15,9,14,20,10,6,5,14,12,7,16,21,18,21,24,23,10,21,16,18,16,18,5,20,19,20,10,14,26,2,9,19,12,28,17,5,7,25,22,16,17,21,11};
        int groupSize4 = 10;
//        System.out.println(isNStraightHand(hand1,groupSize1));
//        System.out.println(isNStraightHand(hand2,groupSize2));
//        System.out.println(isNStraightHand(hand3,groupSize3));
//        System.out.println(isNStraightHand(hand4,groupSize4));
        System.out.println(isNStraightHandBetter(hand1,groupSize1));
        System.out.println(isNStraightHandBetter(hand2,groupSize2));
        System.out.println(isNStraightHandBetter(hand3,groupSize3));
        System.out.println(isNStraightHandBetter(hand4,groupSize4));
    }

    private static boolean isNStraightHandBetter(int[] hand, int groupSize) {
        int handSize = hand.length;
        if(handSize%groupSize!=0){
            return false;
        }
        Map<Integer, Integer> cardFreq = new TreeMap<>();
        for (int cards : hand) {
            cardFreq.put(cards, cardFreq.getOrDefault(cards, 0) + 1);
        }
        System.out.println(cardFreq);
        while (!cardFreq.isEmpty()){
            int current_card = cardFreq.entrySet().iterator().next().getKey();
            for (int i = 0; i < groupSize; i++) {
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

    private static boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0){
            return false;
        }
        Arrays.sort(hand);
        System.out.println(Arrays.toString(hand));
        HashMap<Integer,Integer> maps = new HashMap<>();
        for (Integer nums : hand) {
            if (maps.containsKey(nums)) {
                maps.put(nums, maps.get(nums) + 1);
                continue;
            }
            maps.put(nums, 1);
        }
        System.out.println(maps);
        int index =0;
        while (!maps.isEmpty()){
            int nums = hand[index];
            if(maps.containsKey(nums)) {
                if(maps.get(nums)==1) {
                    maps.remove(nums);
                }
                else {
                    maps.put(nums,maps.get(nums)-1);
                }
                for (int j = 1; j < groupSize; j++) {
                    if(maps.containsKey(nums+j)){
                        if(maps.get(nums+j)==1) {
                            maps.remove(nums+j);
                            index++;
                        }
                        else {
                            maps.put(nums+j,maps.get(nums+j)-1);
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
