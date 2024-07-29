package Array;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1395_NumberTeams {
    static int cnt = 0;
    public static void main(String[] args) {
        int[] rating1 = {2,5,3,4,1};
        int[] rating2 = {2,1,3};
        int[] rating3 = {1,2,3,4};
        System.out.println(numTeams(rating1));
        System.out.println(numTeams(rating2));
        System.out.println(numTeams(rating3));
        System.out.println(numTeamsBest(rating1));
        System.out.println(numTeamsBest(rating2));
        System.out.println(numTeamsBest(rating3));
        System.out.println(numTeamsBetter(rating1));
        System.out.println(numTeamsBetter(rating2));
        System.out.println(numTeamsBetter(rating3));

    }

    private static int numTeamsBest(int[] rating) {
        int answer = 0;
        //increasing
        for(int i =0;i<rating.length;i++){
            int left =  leftCountInc(rating[i],i,rating);
            int right =  rightCountInc(rating[i],i,rating);
            answer+=(left*right);
        }
        //decrease
        for(int i =0;i<rating.length;i++){
            int left =  leftCountDec(rating[i],i,rating);
            int right =  rightCountDec(rating[i],i,rating);
            answer+=(left*right);
        }
        return answer;
    }

    private static int leftCountDec(int num, int index, int[] rating) {
        int count = 0;
        for(int m =0;m<index;m++){
            if(num<rating[m]){
                count++;
            }
        }
        return count;
    }

    private static int rightCountDec(int num, int index, int[] rating) {
        int count = 0;
        for(int m =index+1;m<rating.length;m++){
            if(num>rating[m]){
                count++;
            }
        }
        return count;
    }

    private static int leftCountInc(int num, int index, int[] rating) {
        int count = 0;
        for(int m =0;m<index;m++){
            if(num>rating[m]){
                count++;
            }
        }
        return count;
    }
    private static int rightCountInc(int num, int index, int[] rating) {
        int count = 0;
        for(int m =index+1;m<rating.length;m++){
            if(num<rating[m]){
                count++;
            }
        }
        return count;
    }
    private static int numTeamsBetter(int[] rating) {
        List<Integer> curr1 = new ArrayList<>();
        List<Integer> curr2 = new ArrayList<>();

        recursionIncrease(rating,0,-1,curr1);
        recursionDecrease(rating,0,-1,curr2);
        return cnt;
    }
    private static void recursionIncrease(int[] rating, int idx, int prev,List<Integer> curr) {
        if(curr.size()==3){
            cnt++;
            return;
        }
        for(int i =idx;i<rating.length;i++){
            if(prev==-1 || rating[prev]>rating[i]){
                curr.add(rating[i]);
                recursionIncrease(rating,i+1,i,curr);
                curr.remove(curr.size()-1);
            }
        }
    }
    private static void recursionDecrease(int[] rating, int idx, int prev,List<Integer> curr) {
        if(curr.size()==3){
            cnt++;
            return;
        }
        for(int i =idx;i<rating.length;i++){
            if(prev==-1 || rating[prev]<rating[i]){
                curr.add(rating[i]);
                recursionDecrease(rating,i+1,i,curr);
                curr.remove(curr.size()-1);
            }
        }
    }
    private static int numTeams(int[] rating) {
        int n = rating.length;
        int count = 0;
        for(int i =0;i<n-2;i++){
            for(int j =i+1;j<n-1;j++){
                for(int k =j+1;k<n;k++){
                    int a = rating[i];
                    int b = rating[j];
                    int c = rating[k];
                    if(a<b && b<c){
                        count++;
                    }
                    else if(a>b && b>c){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
