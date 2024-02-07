package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_188 {
    public int maxProfit(int k, int[] prices) {
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        Arrays.fill(sell, 0);
        Arrays.stream(prices).forEach(p -> IntStream.rangeClosed(1, k).forEach(i -> {
            buy[i] = Math.max(buy[i], sell[i - 1] - p);
            sell[i] = Math.max(sell[i], buy[i] + p);
        }));
        return sell[k];
    }
}
