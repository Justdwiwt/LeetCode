package main.java;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] inDegree = new int[graph.length];
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int i = 0; i < graph.length; i++) {
            inDegree[i] = graph[i].length;
            for (int j = 0; j < graph[i].length; j++) {
                map.putIfAbsent(graph[i][j], new HashSet<>());
                map.get(graph[i][j]).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();

        IntStream.range(0, inDegree.length).filter(i -> inDegree[i] == 0).forEach(q::offer);

        while (!q.isEmpty()) {
            int size = q.size();
            IntStream.range(0, size)
                    .map(i -> q.poll())
                    .filter(map::containsKey)
                    .flatMap(curr -> map.get(curr).stream().mapToInt(n -> n))
                    .forEach(n -> {
                        inDegree[n]--;
                        if (inDegree[n] == 0) q.offer(n);
                    });
        }

        return IntStream.range(0, inDegree.length).filter(i -> inDegree[i] == 0).boxed().collect(Collectors.toList());
    }
}
