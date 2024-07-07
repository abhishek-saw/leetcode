package Math;

public class LeetCode1518_NumWaterBottles {
    public static void main(String[] args) {
        int numBottles1 = 9;
        int numExchange1 = 3;
        int numBottles2 = 15;
        int numExchange2 = 4;
        System.out.println(numWaterBottles(numBottles1,numExchange1));
        System.out.println(numWaterBottles(numBottles2,numExchange2));
        System.out.println(numWaterBottlesBetter(numBottles1,numExchange1));
        System.out.println(numWaterBottlesBetter(numBottles2,numExchange2));
    }

    private static int numWaterBottles(int numBottles, int numExchange) {
        int drink = 0;
        drink += numBottles;
        while (numBottles >= numExchange) {
            int div = numBottles / numExchange;
            int rem = numBottles % numExchange;
            drink += div;
            numBottles = div + rem;
        }
        return drink;
    }

    private static int numWaterBottlesBetter(int numBottles, int numExchange) {
        return numBottles + (numBottles - 1) / (numExchange - 1);
    }
}
