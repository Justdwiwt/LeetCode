package main.java;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_2121 {
    public long[] getDistances(int[] arr) {
        HashMap<Integer, List<Integer>> map = IntStream.range(0, arr.length)
                .boxed()
                .collect(Collectors.groupingBy(i -> arr[i], HashMap::new, Collectors.toList()));
        long[] dp = new long[arr.length];
        for (List<Integer> list : map.values()) {
            list.forEach(i -> dp[list.get(0)] += i - list.get(0));
            IntStream.range(1, list.size()).forEach(i -> dp[list.get(i)] = dp[list.get(i - 1)] - (list.size() - 2L * i) * (list.get(i) - list.get(i - 1)));
        }
        return dp;
    }
}
