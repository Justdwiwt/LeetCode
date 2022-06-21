package main.java;

import java.util.stream.IntStream;

public class Solution_2240 {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        return IntStream.rangeClosed(0, total / cost1)
                .mapToLong(i -> (total - (long) i * cost1) / cost2 + 1)
                .sum();
    }
}
