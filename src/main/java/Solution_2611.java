package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2611 {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int res = Arrays.stream(reward2).sum();
        int[] dp = IntStream.range(0, reward1.length).map(i -> reward1[i] - reward2[i]).toArray();
        Arrays.sort(dp);
        for (int i = dp.length - 1; i > dp.length - 1 - k; i--) res += dp[i];
        return res;
    }
}
