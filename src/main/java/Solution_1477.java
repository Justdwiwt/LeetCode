package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution_1477 {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int sum = 0;
        int[][] dp = new int[n + 1][2];
        IntStream.rangeClosed(0, n).forEach(i -> dp[i][0] = dp[i][1] = 0x3F3F3F3F);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 1; i <= n; i++) {
            sum += arr[i - 1];
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = dp[i - 1][1];
            if (map.containsKey(sum - target)) {
                int idx = map.get(sum - target);
                dp[i][0] = Math.min(dp[i][0], i - idx);
                dp[i][1] = Math.min(dp[idx][0] + i - idx, dp[i][1]);
            }
            map.put(sum, i);
        }
        return dp[n][1] == 0x3F3F3F3F ? -1 : dp[n][1];
    }
}
