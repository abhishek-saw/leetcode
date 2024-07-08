package Recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1823_FindTheWinner {
    public static void main(String[] args) {
        int n1 = 5;
        int k1 = 2;
        int n2 = 6;
        int k2 = 5;
        System.out.println(findTheWinnerArray(n1,k1));
        System.out.println(findTheWinnerArray(n2,k2));
        System.out.println(findTheWinnerQueue(n1,k1));
        System.out.println(findTheWinnerQueue(n2,k2));
        System.out.println(findTheWinnerRecursion(n1,k1));
        System.out.println(findTheWinnerRecursion(n2,k2));
    }
    private static int findTheWinnerArray(int n, int k) {
        ArrayList<Integer> circle = new ArrayList<>();
        for(int i = 1;i<=n;i++){
            circle.add(i);
        }
        int i = 0;
        while (circle.size()>1){
            int index = (i+k-1)%circle.size();
            circle.remove(index);
            i = index;
        }
        return circle.get(0);
    }
    private static int findTheWinnerRecursion(int n, int k) {
        return findTheWinnerRecursionHelper(n, k)+1;
    }
    private static int findTheWinnerRecursionHelper(int n, int k) {
        if(n ==1) {
            return 0;
        }
        int idx = findTheWinnerRecursionHelper(n -1, k);
        idx = (idx+ k)% n;
        return idx;
    }

    private static int findTheWinnerQueue(int n, int k) {
        Queue<Integer> pq = new LinkedList<>();
        for(int i =1;i<=n;i++){
            pq.add(i);
        }
        while (pq.size()>1){
            int count = 1;
            while (count<k){
                pq.add(pq.remove());
                count++;
            }
            pq.remove();
        }
        return pq.remove();
    }
}
