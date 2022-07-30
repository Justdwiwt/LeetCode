package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_2065 {
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        List<List<int[]>> adjList = Arrays.stream(values).<List<int[]>>mapToObj(i -> new ArrayList<>()).collect(Collectors.toList());
        Arrays.stream(edges).forEach(edge -> {
            adjList.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adjList.get(edge[1]).add(new int[]{edge[0], edge[2]});
        });
        int[] visited = new int[values.length];
        solve(values, adjList, visited, 0, maxTime, 0, 0);
        return res;
    }

    int res;

    private void solve(int[] values, List<List<int[]>> adjList, int[] visited, int node, int maxTime, int currTime, int score) {
        if (currTime > maxTime) return;
        if (visited[node] == 0) score += values[node];
        if (node == 0) res = Math.max(res, score);
        visited[node]++;
        for (int[] v : adjList.get(node)) solve(values, adjList, visited, v[0], maxTime, currTime + v[1], score);
        visited[node]--;
    }
}
