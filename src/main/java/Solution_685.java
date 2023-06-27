package main.java;

import java.util.*;

public class Solution_685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        Map<Integer, Set<Integer>> parentsMap = new HashMap<>();
        Map<Integer, Set<Integer>> childrenMap = new HashMap<>();
        Set<Integer> points = new HashSet<>();
        Arrays.stream(edges).forEach(edge -> {
            points.add(edge[0]);
            points.add(edge[1]);
            union(edge[0], edge[1], parentsMap);
            union(edge[1], edge[0], childrenMap);
        });
        int[] ret = new int[2];
        for (int[] edge : edges) {
            if (delEdge(parentsMap, childrenMap, points, edge)) ret = edge;
            parentsMap.get(edge[1]).add(edge[0]);
            childrenMap.get(edge[0]).add(edge[1]);
        }
        return ret;
    }

    public boolean delEdge(Map<Integer, Set<Integer>> parentsMap, Map<Integer, Set<Integer>> childrenMap, Set<Integer> points, int[] delEdge) {
        int c = delEdge[0];
        int p = delEdge[1];
        if (!parentsMap.containsKey(p)) return false;
        parentsMap.get(p).remove(c);
        childrenMap.get(c).remove(p);
        int root = points
                .stream()
                .mapToInt(point -> point)
                .filter(point -> !parentsMap.containsKey(point) || parentsMap.get(point).size() == 0)
                .findFirst()
                .orElse(0);
        if (root <= 0 || !childrenMap.containsKey(root) || childrenMap.get(root).size() == 0) return false;
        if (points
                .stream()
                .mapToInt(point -> point)
                .filter(point -> point != root)
                .map(point -> parentsMap.getOrDefault(point, new HashSet<>()).size())
                .anyMatch(parents -> parents != 1))
            return false;
        Set<Integer> curSet = new HashSet<>();
        getAllPointsFromRoot(childrenMap, root, curSet);
        return points.equals(curSet);
    }

    public void getAllPointsFromRoot(Map<Integer, Set<Integer>> childrenMap, int root, Set<Integer> set) {
        set.add(root);
        if (!childrenMap.containsKey(root) || childrenMap.get(root).size() == 0) return;
        childrenMap.get(root).forEach(i -> getAllPointsFromRoot(childrenMap, i, set));
    }

    public void union(int x, int y, Map<Integer, Set<Integer>> parentsMap) {
        parentsMap.computeIfAbsent(y, k -> new HashSet<>()).add(x);
    }
}
