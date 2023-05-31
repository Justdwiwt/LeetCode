package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_785 {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        return IntStream.range(0, graph.length).noneMatch(i -> colors[i] == 0 && !f(graph, colors, 1, i));
    }

    private boolean f(int[][] graph, int[] colors, int color, int node) {
        if (colors[node] != 0) return colors[node] == color;
        colors[node] = color;
        return Arrays.stream(graph[node]).allMatch(next -> f(graph, colors, -color, next));
    }
}
