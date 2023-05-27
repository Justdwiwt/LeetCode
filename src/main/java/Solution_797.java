package main.java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution_797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> way = new LinkedList<>();
        way.add(0);
        f(graph, 0, graph.length - 1, way, ans);
        return ans;
    }

    public void f(int[][] graph, int start, int end, List<Integer> way, List<List<Integer>> ans) {
        if (start == end) {
            ans.add(way);
            return;
        }
        Arrays.stream(graph[start]).forEach(val -> {
            List<Integer> nextWay = new LinkedList<>(way);
            nextWay.add(val);
            f(graph, val, end, nextWay, ans);
        });
    }
}
