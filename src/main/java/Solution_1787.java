package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_1787 {
    public int minChanges(int[] nums, int k) {
        int limit = 1 << 10, len = nums.length, MAX = Integer.MAX_VALUE / 2, groupSize, lastMin;
        int[][] dp = new int[2][limit];
        int[] tmp;
        Arrays.fill(dp[0], MAX);
        dp[0][0] = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.clear();
            groupSize = 0;
            for (int j = i; j < len; j += k) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                groupSize++;
            }

            lastMin = Integer.MAX_VALUE;
            for (int j = 0; j < limit; j++)
                lastMin = Math.min(dp[0][j], lastMin);
            Arrays.fill(dp[1], lastMin);
            for (int j = 0; j < limit; j++) {
                for (Map.Entry<Integer, Integer> entry : map.entrySet())
                    dp[1][j] = Math.min(dp[1][j], dp[0][j ^ entry.getKey()] - entry.getValue());
                dp[1][j] += groupSize;
            }
            tmp = dp[0];
            dp[0] = dp[1];
            dp[1] = tmp;
        }
        return dp[0][0];
    }
}
