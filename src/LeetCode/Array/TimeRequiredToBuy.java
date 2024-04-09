package Array;

public class TimeRequiredToBuy {
    public static void main(String[] args) {
        int [] tickets1 = {2,3,2};
        int k1 = 2;
        int [] tickets2 = {5,1,1,1};
        int k2 = 0;
        System.out.println(timeRequiredToBuy(tickets1,k1));
        System.out.println(timeRequiredToBuy(tickets2,k2));
    }
    public static int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        int i = 0;
        while(tickets[k]!=0) {
            if (i == tickets.length) {
                i = 0;
            }
            if (tickets[i] != 0) {
                int temp = tickets[i];
                tickets[i] = temp - 1;
                time++;
            }
            i++;
        }
        return time;
    }
}
