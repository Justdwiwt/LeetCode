package main.java;

import java.util.*;
import java.util.stream.IntStream;

public class Solution_882 {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        List<int[]>[] path = IntStream.range(0, n).<List<int[]>>mapToObj(i -> new ArrayList<>()).toArray(List[]::new);
        Arrays.stream(edges).forEach(e -> {
            path[e[0]].add(new int[]{e[1], e[2]});
            path[e[1]].add(new int[]{e[0], e[2]});
        });
        int[] dis = new int[n];
        Arrays.fill(dis, (int) 1e9);
        dis[0] = 0;
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        q.add(new int[]{0, 0});
        while (q.size() > 0) {
            int[] a = q.poll();
            path[a[0]].forEach(b -> {
                int d = a[1] + b[1] + 1;
                if (d < dis[b[0]]) {
                    dis[b[0]] = d;
                    q.add(new int[]{b[0], dis[b[0]]});
                }
            });
        }
        int res = (int) IntStream.range(0, n).filter(i -> dis[i] <= maxMoves).count();
        res += Arrays.stream(edges).mapToInt(e -> Math.min(e[2], Math.max(0, maxMoves - dis[e[0]]) + Math.max(0, maxMoves - dis[e[1]]))).sum();
        return res;
    }
}
