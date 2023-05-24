package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution_808 {
    private static final Map<Integer, int[]> map = new HashMap<Integer, int[]>() {{
        put(1, new int[]{100, 0});
        put(2, new int[]{75, 25});
        put(3, new int[]{50, 50});
        put(4, new int[]{25, 75});
    }};

    public double soupServings(int n) {
        if (n >= 4451) return 1;
        double[][] dp = new double[n + 1][n + 1];
        return dfs(n, n, dp);
    }

    private double dfs(int a, int b, double[][] dp) {
        if (a <= 0) {
            if (b <= 0) return 0.5;
            return 1;
        }
        if (b <= 0) return 0;
        if (dp[a][b] != 0) return dp[a][b];

        IntStream.rangeClosed(1, 4).mapToObj(map::get).forEach(choice -> dp[a][b] += 0.25 * dfs(a - choice[0], b - choice[1], dp));
        return dp[a][b];
    }
}
