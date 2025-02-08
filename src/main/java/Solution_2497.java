package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_2497 {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int n = vals.length;
        List<Integer>[] path = IntStream.range(0, n).<List<Integer>>mapToObj(i -> new ArrayList<>()).toArray(List[]::new);
        IntStream.range(0, edges.length).forEach(i -> {
            if (vals[edges[i][1]] > 0) path[edges[i][0]].add(vals[edges[i][1]]);
            if (vals[edges[i][0]] > 0) path[edges[i][1]].add(vals[edges[i][0]]);
        });
        int ans = -(int) 1e4;
        for (int i = 0; i < n; i++) {
            int sum = vals[i], m = Math.min(k, path[i].size());
            path[i].sort((a, b) -> b - a);
            for (int j = 0; j < m; j++) sum += path[i].get(j);
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
