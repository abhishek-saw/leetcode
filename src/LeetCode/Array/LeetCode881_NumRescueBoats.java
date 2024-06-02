package Array;

import java.util.Arrays;

public class LeetCode881_NumRescueBoats {
    public static void main(String[] args) {
        int[] people1 = {1, 2};
        int limit1 = 5;
        int[] people2 = {3, 2, 2, 1};
        int limit2 = 3;
        int[] people3 = {3, 5, 3, 4};
        int limit3 = 5;
        int[] people4 = {2, 4};
        int limit4 = 5;
        int[] people5 = {3, 2, 3, 2, 2};
        int limit5 = 6;
        int[] people6 = {5, 1, 4, 2};
        int limit6 = 6;
        System.out.println(numRescueBoats(people1, limit1));
        System.out.println(numRescueBoats(people2, limit2));
        System.out.println(numRescueBoats(people3, limit3));
        System.out.println(numRescueBoats(people4, limit4));
        System.out.println(numRescueBoats(people5, limit5));
        System.out.println(numRescueBoats(people6, limit6));
    }

    private static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int start = 0;
        int end = people.length - 1;
        while (start <= end) {
            if (people[start] + people[end] <= limit) {
                start++;
                end--;
            } else  {
                end--;
            }
            count++;
        }
        return count;
    }
}