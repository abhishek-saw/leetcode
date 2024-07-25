package Math;

public class LeetCode1344_AngleBetweenHands {
    public static void main(String[] args) {
        int hour1 = 12;
        int minutes1 = 30;
        int hour2 = 3;
        int minutes2 = 30;
        int hour3 = 3;
        int minutes3 = 15;
        int hour4 = 1;
        int minutes4 = 57;
        System.out.println(angleClock(hour1,minutes1));
        System.out.println(angleClock(hour2,minutes2));
        System.out.println(angleClock(hour3,minutes3));
        System.out.println(angleClock(hour4,minutes4));
    }

    private static double angleClock(int hour, int minutes) {
        if (hour == 12) {
            hour = 0;
        }
        double min = 5.5 * minutes;
        double hr = 30 * ((double) hour % 12);
        double diff = Math.abs(hr - min);
        return diff > 180 ? 360 - diff : diff;
    }
}
