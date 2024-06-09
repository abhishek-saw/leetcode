package AllLeetCodeContest;

import java.util.Arrays;

public class LeetCode3179_ValueAfterKSeconds {
    public static void main(String[] args) {
        int n1 = 4;
        int k1 = 5;
        int n2 = 5;
        int k2 = 3;
        int n3 = 5;
        int k3 = 1000;
        System.out.println(valueAfterKSeconds(n1,k1));
        System.out.println(valueAfterKSeconds(n2,k2));
        System.out.println(valueAfterKSeconds(n3,k3));

    }

    private static int valueAfterKSeconds(int n, int k) {
        int [] array = new int [n];
        Arrays.fill(array,1);
        int m = 1000000007;
        for(int i = 0;i<k;i++){
            for(int j =1;j< array.length;j++){
                array[j] = (array[j]+array[j-1])%(m);
            }
        }
        System.out.println(Arrays.toString(array));
        return array[n-1];
    }
}
