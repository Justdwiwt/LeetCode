package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_2791 {
    List<int[]>[] graph;

    public long countPalindromePaths(List<Integer> parent, String s) {
        int N = parent.size();
        char[] str = s.toCharArray();
        graph = new List[N];
        IntStream.range(0, N).forEach(i -> graph[i] = new ArrayList<>());
        IntStream.range(1, N).forEach(i -> {
            int p = parent.get(i);
            graph[i].add(new int[]{p, str[i] - 'a'});
            graph[p].add(new int[]{i, str[i] - 'a'});
        });
        return dfs(-1, 0, 0, new HashMap<>());
    }

    public long dfs(int parent, int cur, int status, HashMap<Integer, Integer> map) {
        long ans = 0;
        for (int[] next : graph[cur]) {
            if (next[0] == parent) continue;
            int c = status ^ (1 << next[1]);
            if (c == (c & -c)) ans++;
            ans += map.getOrDefault(c, 0);
            ans += IntStream.range(0, 26).mapToLong(i -> map.getOrDefault(c ^ (1 << i), 0)).sum();
            map.merge(c, 1, Integer::sum);
            ans += dfs(cur, next[0], c, map);
        }
        return ans;
    }
}
