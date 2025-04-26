package main.java;

import java.util.*;
import java.util.stream.IntStream;

public class Solution_2581 {
    public int rootCount(int[][] edges, int[][] guesses, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Arrays.stream(edges).forEach(edge -> {
            List<Integer> list = map.computeIfAbsent(edge[0], l -> new ArrayList<>());
            list.add(edge[1]);
            list = map.computeIfAbsent(edge[1], l -> new ArrayList<>());
            list.add(edge[0]);
        });
        Set<Long> set = new HashSet<>();
        Arrays.stream(guesses).forEach(guesse -> {
            long f = ((long) guesse[0] << 32) | ((long) guesse[1]);
            set.add(f);
        });
        Map<Long, Integer> flagMap = new HashMap<>();

        return (int) IntStream.rangeClosed(0, edges.length).map(i -> dfs(-1, i, map, flagMap, set)).filter(q -> q >= k).count();
    }

    private int dfs(int f, int n, Map<Integer, List<Integer>> map, Map<Long, Integer> flagMap, Set<Long> set) {
        long t = ((long) f << 32) | ((long) n);
        if (flagMap.containsKey(t)) return flagMap.get(t);
        List<Integer> list = map.get(n);
        int m = 0;
        for (Integer next : list)
            if (next != f) {
                long t_ = ((long) n << 32) | ((long) next);
                if (set.contains(t_)) m++;
                m += dfs(n, next, map, flagMap, set);
            }
        flagMap.put(t, m);
        return m;
    }
}
