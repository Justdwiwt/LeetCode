package main.java;

public class Solution_121 {
    public int maxProfit(int[] prices) {
        int max = 0, min = Integer.MAX_VALUE;
        for (int price : prices)
            if (price < min) min = price;
            else max = Math.max(price - min, max);
        return max;
    }
}
