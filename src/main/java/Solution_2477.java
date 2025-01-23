package main.java;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_2477 {
    private int cnt;

    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        ArrayList<ArrayList<Integer>> graph = IntStream.range(0, n)
                .<ArrayList<Integer>>mapToObj(i -> new ArrayList<>())
                .collect(Collectors.toCollection(ArrayList::new));

        IntStream.range(0, roads.length).forEach(i -> {
            int a = roads[i][0], b = roads[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        });

        int[] dfn = new int[n + 1];
        int[] size = new int[n + 1];
        long[] cost = new long[n + 1];
        cnt = 0;
        dfs(graph, 0, dfn, size, cost, seats);
        return cost[0];
    }

    private void dfs(ArrayList<ArrayList<Integer>> graph, int cur, int[] dfn, int[] size, long[] cost, int seats) {
        dfn[cur] = ++cnt;
        size[cur] = 1;
        graph.get(cur).stream().mapToInt(next -> next).filter(next -> dfn[next] == 0).forEach(next -> {
            dfs(graph, next, dfn, size, cost, seats);
            size[cur] += size[next];
            cost[cur] += cost[next];
            cost[cur] += (size[next] + seats - 1) / seats;
        });
    }
}
