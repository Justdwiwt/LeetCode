package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_886 {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[][] graph = new int[N][N];
        Arrays.stream(dislikes).forEach(d -> {
            graph[d[0] - 1][d[1] - 1] = 1;
            graph[d[1] - 1][d[0] - 1] = 1;
        });
        int[] group = new int[N];
        return IntStream.range(0, N).noneMatch(i -> group[i] == 0 && dfs(graph, group, i, 1));
    }

    private boolean dfs(int[][] graph, int[] group, int index, int g) {
        group[index] = g;
        return IntStream.range(0, graph.length).anyMatch(i -> graph[index][i] == 1 && (group[i] == g || group[i] == 0 && dfs(graph, group, i, -g)));
    }
}
