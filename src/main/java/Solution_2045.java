package main.java;

import java.util.*;

public class Solution_2045 {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        Map<Integer, Set<Integer>> m = new HashMap<>();
        Arrays.stream(edges).forEach(e -> {
            m.putIfAbsent(e[0], new HashSet<>());
            m.get(e[0]).add(e[1]);
            m.putIfAbsent(e[1], new HashSet<>());
            m.get(e[1]).add(e[0]);
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Map<Integer, Set<Integer>> visited = new HashMap<>();
        pq.offer(new int[]{1, 0});
        int pre = -1;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0], t = cur[1];
            if (node == n) {
                if (pre == -1 || t == pre) pre = t;
                else return t;
            }
            if (t % (2 * change) >= change)
                t += (2 * change - t % (2 * change));
            visited.putIfAbsent(node, new HashSet<>());
            if (!visited.get(node).add(t) || visited.get(node).size() >= 3) continue;
            if (m.containsKey(node))
                for (int next : m.get(node))
                    pq.offer(new int[]{next, t + time});
        }
        return -1;
    }
}
