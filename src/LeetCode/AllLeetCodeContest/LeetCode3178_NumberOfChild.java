package AllLeetCodeContest;

public class LeetCode3178_NumberOfChild {
    public static void main(String[] args) {
        int n1 = 3;
        int k1 = 5;
        int n2 = 5;
        int k2 = 6;
        int n3 = 4;
        int k3 = 2;
        System.out.println(numberOfChild(n1,k1));
        System.out.println(numberOfChild(n2,k2));
        System.out.println(numberOfChild(n3,k3));
    }

    private static int numberOfChild(int n, int k) {
        boolean flag = true;
        int count = 0;
        int round = 0;
        while (round<k){
            if(count==n-1){
                flag = false;
            }
            if(count==0){
                flag = true;
            }
            if(flag){
                count++;
            }
            else {
                count--;
            }
            round++;
        }
        return count;
    }
}
