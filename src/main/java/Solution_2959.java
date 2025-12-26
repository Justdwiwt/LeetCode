package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_2959 {
    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        int ans = 0;
        for (int s = 0; s < (1 << n); s++) {
            int[][] dp = new int[n][n];
            Arrays.stream(dp).forEach(a -> Arrays.fill(a, Integer.MAX_VALUE));
            for (int i = 0; i < n; i++) {
                if ((s >> i & 1) == 0) continue;
                dp[i][i] = 0;
            }
            List<int[]>[] g = new ArrayList[n];
            Arrays.setAll(g, i -> new ArrayList<>());
            for (int[] a : roads) {
                int x = a[0], y = a[1], z = a[2];
                if ((s >> x & 1) == 1 && (s >> y & 1) == 1) {
                    g[x].add(new int[]{y, z});
                    g[y].add(new int[]{x, z});
                    dp[x][y] = Math.min(dp[x][y], z);
                    dp[y][x] = Math.min(dp[y][x], z);
                }
            }
            for (int k = 0; k < n; k++) {
                if ((s >> k & 1) == 0) continue;
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < n; j++)
                        if (dp[i][k] != Integer.MAX_VALUE && dp[k][j] != Integer.MAX_VALUE)
                            dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
            }
            boolean ok = true;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if ((s >> i & 1) == 1 && (s >> j & 1) == 1)
                        if (dp[i][j] > maxDistance || dp[j][i] > maxDistance) {
                            ok = false;
                            break;
                        }
            if (ok) ans++;
        }
        return ans;
    }
}
