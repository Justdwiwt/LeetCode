package main.java;

import java.util.stream.IntStream;

public class Solution_122 {
    public int maxProfit(int[] prices) {
        return IntStream.range(1, prices.length)
                .filter(i -> prices[i] > prices[i - 1])
                .map(i -> prices[i] - prices[i - 1])
                .sum();
    }
}
