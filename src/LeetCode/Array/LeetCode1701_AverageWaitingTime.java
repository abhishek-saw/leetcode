package Array;

public class LeetCode1701_AverageWaitingTime {
    public static void main(String[] args) {
        int[][] customers1 = {{1,2},{2,5},{4,3}};
        int[][] customers2 = {{5,2},{5,4},{10,3},{20,1}};
        int[][] customers3 = {{2,3},{6,3},{7,5},{11,3},{15,2},{18,1}};
        System.out.println(averageWaitingTime(customers1));
        System.out.println(averageWaitingTime(customers2));
        System.out.println(averageWaitingTime(customers3));
    }

    private static double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        double timeWait = customers[0][1];
        int prev = customers[0][0] + customers[0][1];

        for (int index = 1; index < n; ++index) {
            int[] times = customers[index];
            int arrive = times[0];

            int start_cook = Math.max(arrive, prev);
            int end_time = start_cook + times[1];
            prev = end_time;
            timeWait += end_time - arrive;
        }

        return timeWait / n;
    }
}