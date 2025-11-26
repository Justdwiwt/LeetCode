package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2925 {
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        int n = values.length;
        ArrayList<Integer>[] g = IntStream.range(0, n).<ArrayList<Integer>>mapToObj(i -> new ArrayList<>()).toArray(ArrayList[]::new);
        Arrays.stream(edges).forEach(e -> {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        });
        long[] ans = dfs(0, g, -1, values);
        return ans[0];
    }

    private long[] dfs(int cur, ArrayList<Integer>[] g, int p, int[] values) {
        long[] res = new long[2];
        long sum = 0, f = 0;
        for (int w : g[cur]) {
            if (w == p) continue;
            long[] a = dfs(w, g, cur, values);
            f += a[1];
            sum += a[0];
        }
        res[0] = Math.max(values[cur] + sum, f);
        if (g[cur].size() == 1 && cur != 0) res[0] = 0;
        res[1] = f + values[cur];
        return res;
    }
}
