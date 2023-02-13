package main.java;

import java.util.Arrays;
import java.util.TreeMap;

public class Solution_1187 {
    public int makeArrayIncreasing(int[] n1, int[] n2) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        Arrays.sort(n2);
        Arrays.stream(n2).forEach(n -> tm.putIfAbsent(n, tm.size()));
        int[] cnt = new int[n1.length + 2];
        System.arraycopy(n1, 0, cnt, 1, n1.length);
        cnt[0] = -1;
        cnt[cnt.length - 1] = Integer.MAX_VALUE;
        int n = cnt.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < n; ++i) {
            Integer high = tm.lowerKey(cnt[i]);
            for (int j = i - 1; j >= 0; --j) {
                if (dp[j] == -1 || cnt[j] >= cnt[i]) continue;
                Integer low = tm.higherKey(cnt[j]);
                int sep = low == null || high == null ? 0 : tm.get(high) - tm.get(low) + 1;
                if (sep < (i - j + 1) - 2) continue;
                int ch = dp[j] + (i - j + 1) - 2;
                dp[i] = dp[i] == -1 ? ch : Math.min(dp[i], ch);
            }
        }
        return dp[n - 2] == -1 || dp[n - 1] == -1 ? Math.max(dp[n - 2], dp[n - 1]) : Math.min(dp[n - 2], dp[n - 1]);
    }
}
