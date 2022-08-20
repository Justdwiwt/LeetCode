package main.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_1971 {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        ArrayList<ArrayList<Integer>> adj = IntStream.range(0, n).<ArrayList<Integer>>mapToObj(i -> new ArrayList<>()).collect(Collectors.toCollection(ArrayList::new));
        IntStream.range(0, edges.length).forEach(i -> {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        });
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> vis = new HashSet<>();
        q.add(start);
        while (!q.isEmpty()) {
            int u = q.poll();
            vis.add(u);
            if (u == end) return true;
            adj.get(u).stream().mapToInt(v -> v).filter(v -> !vis.contains(v)).forEach(q::add);
        }
        return false;
    }
}
