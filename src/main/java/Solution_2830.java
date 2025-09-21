package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_2830 {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        int[] dp = new int[n + 1];
        Map<Integer, List<int[]>> map = offers.stream()
                .collect(Collectors.groupingBy(offer -> offer.get(1), Collectors.mapping(offer -> new int[]{offer.get(0), offer.get(1), offer.get(2)}, Collectors.toList())));
        IntStream.range(0, n).forEach(i -> {
            List<int[]> list = map.getOrDefault(i, new ArrayList<>());
            dp[i + 1] = dp[i];
            list.forEach(ints -> dp[i + 1] = Math.max(dp[i + 1], dp[ints[0]] + ints[2]));
        });
        return dp[n];
    }
}
