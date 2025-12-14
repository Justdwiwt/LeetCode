package main.java;

public class Solution_2945 {
    private static final int MAXN = (int) 1e5 + 10;

    private static final int[] dp = new int[MAXN];
    private static final int[] que = new int[MAXN];

    private static final long[] s = new long[MAXN];
    private static final long[] last = new long[MAXN];

    public int findMaximumLength(int[] nums) {
        int n = nums.length, hh = 0, tt = 0;

        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + nums[i - 1];
            while (hh < tt && s[que[hh + 1]] + last[que[hh + 1]] <= s[i]) hh++;
            dp[i] = dp[que[hh]] + 1;
            last[i] = s[i] - s[que[hh]];
            while (hh <= tt && s[que[tt]] + last[que[tt]] >= s[i] + last[i]) tt--;
            que[++tt] = i;
        }

        return dp[n];
    }
}
