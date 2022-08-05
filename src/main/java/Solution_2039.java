package main.java;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_2039 {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        List<List<Integer>> list = IntStream.range(0, patience.length).mapToObj(l -> new ArrayList<Integer>()).collect(Collectors.toList());
        Arrays.stream(edges).forEach(e -> {
            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
        });
        Queue<Integer> q = new LinkedList<>();
        boolean[] seen = new boolean[patience.length];
        int res = 0, time = 0;
        for (seen[0] = true, q.add(0); !q.isEmpty(); time++)
            for (int size = q.size(); size > 0; size--) {
                int u = q.poll(), roundTripTime = 2 * time, idle = roundTripTime + 1;
                if (patience[u] < roundTripTime)
                    idle += roundTripTime - (roundTripTime % patience[u] == 0 ? patience[u] : roundTripTime % patience[u]);
                res = Math.max(res, idle);
                list.get(u).stream().filter(v -> !seen[v]).forEach(v -> {
                    q.offer(v);
                    seen[v] = true;
                });
            }
        return res;
    }
}
