package main.java;

import java.util.List;
import java.util.stream.IntStream;

public class Solution_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = IntStream.range(0, n).map(i -> triangle.get(n - 1).get(i)).toArray();
        for (int i = n - 2; i >= 0; i--)
            for (int j = 0; j <= i; j++) dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
        return dp[0];
    }
}
