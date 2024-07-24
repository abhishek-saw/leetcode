package Array;

import java.util.Arrays;

public class LeetCode167_TwoSumII {
    public static void main(String[] args) {
        int[] numbers1 = {2,7,11,15};
        int target1 = 9;
        int[] numbers2 = {2,3,4};
        int target2 = 6;
        int[] numbers3 = {-1,0};
        int target3 = -1;
        int[] numbers4 = {-3,3,4,90};
        int target4 = 0;
        int[] numbers5 = {-1,-1,1,1,1,1};
        int target5 = -2;
        int[] numbers6 = {5,25,75};
        int target6 = 100;
        System.out.println(Arrays.toString(twoSum(numbers1, target1)));
        System.out.println(Arrays.toString(twoSum(numbers2, target2)));
        System.out.println(Arrays.toString(twoSum(numbers3, target3)));
        System.out.println(Arrays.toString(twoSum(numbers4, target4)));
        System.out.println(Arrays.toString(twoSum(numbers5, target5)));
        System.out.println(Arrays.toString(twoSum(numbers6, target6)));

    }

    private static int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while (start <= end) {
            int nums = numbers[start] + numbers[end];
            if (nums == target) {
                return new int[] { start + 1, end + 1 };
            } else if (nums > target) {
                if (numbers[start] > 0 && target > 0) {
                    end--;
                } else if (numbers[start] < 0 && target > 0) {
                    start++;
                } else if (numbers[start] < 0 && target < 0) {
                    end--;
                } else {
                    end--;
                }
            } else {
                if (numbers[start] > 0 && target > 0) {
                    start++;
                } else if (numbers[start] < 0 && target < 0) {
                    end--;
                } else if (numbers[start] < 0 && target > 0) {
                    start++;
                } else {
                    start++;
                }
            }
        }
        return new int[2];
    }
}
