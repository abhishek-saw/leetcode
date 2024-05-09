package Stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures1 = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] temperatures2 = {30, 40, 50, 60};
        int[] temperatures3 = {30, 60, 90};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures1)));
        System.out.println(Arrays.toString(dailyTemperatures(temperatures2)));
        System.out.println(Arrays.toString(dailyTemperatures(temperatures3)));
        System.out.println(Arrays.toString(dailyTemperaturesBetter(temperatures1)));
        System.out.println(Arrays.toString(dailyTemperaturesBetter(temperatures2)));
        System.out.println(Arrays.toString(dailyTemperaturesBetter(temperatures3)));
    }

    private static int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                ans[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }
    private static int[] dailyTemperaturesBetter(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            int current = temperatures[i];
            if (current >= max) {
                max = current;
                continue;
            }
            int days = 1;
            while (temperatures[i + days] <= current) {
                days += ans[i + days];
            }
            ans[i] = days;
        }
        return ans;
    }
}