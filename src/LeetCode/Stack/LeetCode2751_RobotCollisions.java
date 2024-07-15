package Stack;

import java.util.*;

public class LeetCode2751_RobotCollisions {
    public static void main(String[] args) {
        int [] positions1 = {5,4,3,2,1};
        int [] healths1 = {2,17,9,15,10};
        String directions1 = "RRRRR";
        int [] positions2 = {3,5,2,6};
        int [] healths2 = {10,10,15,12};
        String directions2 = "RLRL";
        int [] positions3 = {1,2,5,6};
        int [] healths3 = {10,10,11,11};
        String directions3 = "RLRL";
        System.out.println(survivedRobotsHealths(positions1,healths1,directions1));
        System.out.println(survivedRobotsHealths(positions2,healths2,directions2));
        System.out.println(survivedRobotsHealths(positions3,healths3,directions3));
    }
    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<int[]> robots = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            robots.add(new int[]{positions[i], healths[i], directions.charAt(i), i});
        }

        robots.sort(Comparator.comparingInt(a -> a[0]));

        Stack<int[]> stack = new Stack<>();

        for (int[] robot : robots) {
            if (robot[2] == 'R' || stack.isEmpty() || stack.peek()[2] == 'L') {
                stack.push(robot);
                continue;
            }

            if (robot[2] == 'L') {
                boolean add = true;
                while (!stack.isEmpty() && stack.peek()[2] == 'R' && add) {
                    int last_health = stack.peek()[1];
                    if (robot[1] > last_health) {
                        stack.pop();
                        robot[1] -= 1;
                    } else if (robot[1] < last_health) {
                        stack.peek()[1] -= 1;
                        add = false;
                    } else {
                        stack.pop();
                        add = false;
                    }
                }

                if (add) {
                    stack.push(robot);
                }
            }
        }

        List<int[]> resultList = new ArrayList<>(stack);
        resultList.sort(Comparator.comparingInt(a -> a[3]));

        List<Integer> result = new ArrayList<>();
        for (int[] robot : resultList) {
            result.add(robot[1]);
        }

        return result;
    }
}