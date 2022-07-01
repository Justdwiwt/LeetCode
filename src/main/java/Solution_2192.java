package main.java;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_2192 {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Map<Integer, List<Integer>> m = IntStream.range(0, n)
                .boxed()
                .collect(Collectors.toMap(i -> i, i -> new ArrayList<>(), (a, b) -> b));

        IntStream.range(0, edges.length).forEach(i -> m.get(edges[i][1]).add(edges[i][0]));

        List<List<Integer>> res = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            Set<Integer> st = new HashSet<>();
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while (!q.isEmpty()) {
                int idx = q.poll();
                if (idx != i) st.add(idx);
                m.get(idx).stream().filter(id -> !st.contains(id)).forEach(q::offer);
            }
            res.add(st.stream().sorted().collect(Collectors.toList()));
        });
        return res;
    }
}
