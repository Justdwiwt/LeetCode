package main.java;

public class Solution_2110 {
    public long getDescentPeriods(int[] prices) {
        int start = 0;
        long res = 0;
        for (int i = 1; i < prices.length; i++) {
            res += i - start;
            if (prices[i] != prices[i - 1] - 1) start = i;
        }
        return res + prices.length - start;
    }
}
