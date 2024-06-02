package Array;


public class LeetCode121_MaxProfit {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        int minCostBuy = Integer.MAX_VALUE;
        int profit = 0;
        int currProfit ;
        for (int price : prices) {
            if (price < minCostBuy) { //process of getting the minimum
                minCostBuy = price;
            }
            currProfit = price - minCostBuy; // for current profit just use the simple subtraction
            if (profit < currProfit) {
                profit = currProfit;
            }
        }
        return profit;
    }
}