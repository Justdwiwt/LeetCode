package main.java;

public class Solution_1714 {
    public int[] solve(int[] nums, int[][] queries) {
        final int M = (int) 1e9 + 7;
        int n = nums.length, m = queries.length;
        long[][] dp = new long[n][110];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][0] = nums[i] % M;
            for (int j = 1; j <= 100; j++) {
                dp[i][j] = nums[i];
                if (i + j < n) dp[i][j] += dp[i + j][j];
                dp[i][j] %= M;
            }
        }

        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int x = queries[i][0], y = queries[i][1];
            if (y <= 100) res[i] = (int) dp[x][y];
            else {
                long now = nums[x];
                for (int j = x + y; j < n; j += y) now = (now + nums[j]) % M;
                res[i] = (int) now;
            }
        }
        return res;
    }
}
