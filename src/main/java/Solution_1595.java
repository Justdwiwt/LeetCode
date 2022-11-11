package main.java;

import java.util.List;

public class Solution_1595 {
    public int connectTwoGroups(List<List<Integer>> cost) {
        int n = cost.size(), m = cost.get(0).size();
        int all = 1 << m;
        int[][] dp = new int[n + 1][all];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j < all; j++)
                dp[i][j] = -1;
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 0; j < all; j++) {
                if (dp[i - 1][j] == -1)
                    continue;
                int bj = (~j) & (all - 1);
                for (int sub = bj; sub > 0; sub = (sub - 1) & bj) {
                    int cur = 0;
                    for (int k = 0; k < m; k++)
                        if ((sub & (1 << k)) > 0)
                            cur += cost.get(i - 1).get(k);
                    int next = j | sub, val = dp[i - 1][j] + cur;
                    if (dp[i][next] == -1 || val < dp[i][next])
                        dp[i][next] = val;
                }
                for (int k = 0; k < m; k++) {
                    int next = j | (1 << k), val = dp[i - 1][j] + cost.get(i - 1).get(k);
                    if (dp[i][next] == -1 || val < dp[i][next])
                        dp[i][next] = val;
                }
            }
        return dp[n][all - 1];
    }
}
