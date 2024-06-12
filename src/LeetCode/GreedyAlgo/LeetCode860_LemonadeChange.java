package GreedyAlgo;

public class LeetCode860_LemonadeChange {
    public static void main(String[] args) {
        int[] bills1 = {5,5,5,10,20};
        int[] bills2 = {5,5,10,10,20};
        System.out.println(lemonadeChange(bills1));
        System.out.println(lemonadeChange(bills2));
    }
    private static boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        int twenty = 0;
        for(int bill:bills){
            if(bill==5){
                five++;
            }
            else if(bill==10) {
                if(five<0){
                    return false;
                }
                ten++;
                five--;
            }
            else {
                if(five>0 && ten>0){
                    five--;
                    ten--;
                }
                else if(five>2){
                    five-=3;
                }
                else {
                    return false;
                }
                twenty++;
            }

        }
        return true;
    }
}
