package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_2101 {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length, res = 0;
        Map<Integer, List<Integer>> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            m.put(i, new ArrayList<>());
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                double dist = Math.sqrt(Math.pow(bombs[j][1] - bombs[i][1], 2) + Math.pow(bombs[j][0] - bombs[i][0], 2));
                if (dist <= (double) bombs[i][2]) m.get(i).add(j);
            }
        }
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            res = Math.max(res, dfs(bombs, i, visited, m));
        }
        return res;
    }

    private int dfs(int[][] bombs, int i, boolean[] visited, Map<Integer, List<Integer>> map) {
        if (visited[i]) return 0;
        visited[i] = true;
        int res = 1;
        res += map.get(i).stream().mapToInt(j -> j).map(j -> dfs(bombs, j, visited, map)).sum();
        return res;
    }
}
