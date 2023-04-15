package main.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution_924 {
    Set<Integer>[] spreads;

    public int minMalwareSpread(int[][] graph, int[] initial) {
        Arrays.sort(initial);
        int m = initial.length;
        spreads = new HashSet[m];
        IntStream.range(0, m).forEach(i -> {
            spreads[i] = new HashSet<>();
            dfs(spreads[i], initial[i], graph);
        });

        Set<Integer>[] lasts = new HashSet[m + 1];
        lasts[m] = new HashSet<>();
        for (int i = m - 1; i >= 0; i--) {
            Set<Integer> tmp = new HashSet<>(lasts[i + 1]);
            tmp.addAll(spreads[i]);
            lasts[i] = tmp;
        }

        int res = initial[0];
        int spread = Integer.MAX_VALUE;
        Set<Integer> tmp = new HashSet<>();
        for (int i = 0; i < m; i++) {
            Set<Integer> curr = new HashSet<>(tmp);
            curr.addAll(lasts[i + 1]);
            if (curr.size() < spread) {
                spread = curr.size();
                res = initial[i];
            }
            tmp.addAll(spreads[i]);
        }
        return res;
    }

    private void dfs(Set<Integer> spread, int index, int[][] graph) {
        if (spread.contains(index)) return;
        spread.add(index);
        IntStream.range(0, graph[index].length).filter(i -> graph[index][i] == 1).forEach(i -> dfs(spread, i, graph));
    }
}
