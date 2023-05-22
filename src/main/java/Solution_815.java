package main.java;

import java.util.*;
import java.util.stream.IntStream;

public class Solution_815 {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) return 0;
        Map<Integer, Set<Integer>> posMap = new HashMap<>();
        IntStream.range(0, routes.length).forEach(i -> Arrays.stream(routes[i]).forEach(k -> {
            if (!posMap.containsKey(k)) posMap.put(k, new HashSet<>());
            posMap.get(k).add(i);
        }));
        boolean[] visited = new boolean[routes.length];
        Deque<Integer> queue = new ArrayDeque<>(posMap.get(S));
        posMap.get(S).forEach(k -> visited[k] = true);
        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int bus = queue.poll();
                for (int k : routes[bus]) {
                    if (k == T) return res;
                    posMap.get(k).stream().mapToInt(idx -> idx).filter(idx -> !visited[idx]).forEach(idx -> {
                        queue.add(idx);
                        visited[idx] = true;
                    });
                }
            }
            res++;
        }
        return -1;
    }
}
