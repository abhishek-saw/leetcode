package GreedyAlgo;

import java.util.Arrays;

public class LeetCode2037_MinMovesToSeat {
    public static void main(String[] args) {
        int[] seats1 = {3,1,5};
        int[] students1 = {2,7,4};
        int[] seats2 = {4,1,5,9};
        int[] students2 = {1,3,2,6};
        System.out.println(minMovesToSeat(seats1,students1));
        System.out.println(minMovesToSeat(seats2,students2));
        System.out.println(minMovesToSeatBetter(seats1,students1));
        System.out.println(minMovesToSeatBetter(seats2,students2));
    }

    private static int minMovesToSeatBetter(int[] seats, int[] students) {
        int[] array = new int[Math.max(findMax(seats),findMax(students))];
        for(int i: seats){
            array[i-1]++;
        }
        for(int i: students){
            array[i-1]--;
        }
        int moves = 0;
        int unmatched =0;
        System.out.println(Arrays.toString(array));
        for (int difference : array) {
            moves += Math.abs(unmatched);
            unmatched += difference;
        }
        return moves;
    }

    private static int findMax(int[] array) {
        int max = Integer.MIN_VALUE;
        for(int i :array){
            max = Math.max(max,i);
        }
        return max;
    }

    private static int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int count = 0;
        for(int i =0;i<seats.length;i++){
            count += Math.abs(seats[i] -students[i]);
        }
        return count;
    }
}
