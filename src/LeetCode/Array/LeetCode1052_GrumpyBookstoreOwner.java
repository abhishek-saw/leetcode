package Array;

public class LeetCode1052_GrumpyBookstoreOwner {
    public static void main(String[] args) {
        int[] customers1 = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy1 = {0, 1, 0, 1, 0, 1, 0, 1};
        int minutes1 = 3;
        int[] customers2 = {1};
        int[] grumpy2 = {0};
        int minutes2 = 1;
        int[] customers3 = {10, 1, 7};
        int[] grumpy3 = {0, 0, 0};
        int minutes3 = 2;
        int[] customers4 = {4,10,10};
        int[] grumpy4 = {1,1,0};
        int minutes4 = 2;
        System.out.println(maxSatisfied(customers1, grumpy1, minutes1));
        System.out.println(maxSatisfied(customers2, grumpy2, minutes2));
        System.out.println(maxSatisfied(customers3, grumpy3, minutes3));
        System.out.println(maxSatisfied(customers4, grumpy4, minutes4));
    }

    private static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int satisfied = 0;
        int partSatisfied = 0;
        for(int i =0;i<customers.length;i++){
            if(i<minutes) {
                partSatisfied += customers[i];
            }else {
                if(grumpy[i]==0){
                    partSatisfied += customers[i];
                }
            }
        }
        int index = 0;
        for(int j = minutes;j<customers.length;j++){
            satisfied = Math.max(satisfied,partSatisfied);
            if(grumpy[index]==1){
                partSatisfied-=customers[index];
            }
            if(grumpy[j]==1){
                partSatisfied+=customers[j];
            }
            index++;
        }
        return Math.max(satisfied,partSatisfied);
    }
}
