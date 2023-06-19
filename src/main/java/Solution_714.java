package main.java;

public class Solution_714 {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 1) return 0;
        int base = prices[0] + fee;
        int profit = 0;
        for (int i = 1; i < prices.length; ++i)
            if (prices[i] > base) {
                profit += prices[i] - base;
                base = prices[i];
            } else if (prices[i] + fee < base) base = prices[i] + fee;
        return profit;
    }
}
