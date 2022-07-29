package main.java;

import java.util.stream.IntStream;

public class Solution_2073 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        return IntStream.range(0, tickets.length)
                .map(i -> Math.min(tickets[i], i <= k ? tickets[k] : tickets[k] - 1))
                .sum();
    }
}
