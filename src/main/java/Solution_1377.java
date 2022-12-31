package main.java;

import java.util.*;
import java.util.stream.Collectors;

public class Solution_1377 {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        boolean[] visited = new boolean[n + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        Arrays.stream(edges).forEach(e -> {
            map.putIfAbsent(e[0], new LinkedList<>());
            map.get(e[0]).add(e[1]);
            map.putIfAbsent(e[1], new LinkedList<>());
            map.get(e[1]).add(e[0]);
        });
        return dfs(map, visited, t, target, 1, 1);
    }

    private double dfs(Map<Integer, List<Integer>> map, boolean[] visited, int t, int target, int cur, double p) {
        if (t < 0) return 0;
        List<Integer> next = map.getOrDefault(cur, Collections.emptyList()).stream().filter(i -> !visited[i]).collect(Collectors.toList());
        if (t == 0 || next.size() == 0)
            return cur == target ? p : 0;
        double res;
        p /= next.size();
        visited[cur] = true;
        for (Integer n : next)
            if ((res = dfs(map, visited, t - 1, target, n, p)) > 0)
                return res;
        visited[cur] = false;
        return 0;
    }
}
