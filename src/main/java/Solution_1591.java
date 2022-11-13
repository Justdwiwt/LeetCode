package main.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution_1591 {
    public boolean isPrintable(int[][] targetGrid) {
        int m = targetGrid.length, n = targetGrid[0].length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, int[][]> bound = new HashMap<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                int[][] cur = bound.getOrDefault(targetGrid[i][j], new int[][]{{Integer.MAX_VALUE, Integer.MAX_VALUE}, {0, 0}});
                cur[0][0] = Math.min(i, cur[0][0]);
                cur[0][1] = Math.min(j, cur[0][1]);
                cur[1][0] = Math.max(i, cur[1][0]);
                cur[1][1] = Math.max(j, cur[1][1]);
                bound.put(targetGrid[i][j], cur);
            }
        bound.forEach((key1, val) -> {
            int key = key1;
            Set<Integer> father = map.getOrDefault(key, new HashSet<>());
            for (int i = val[0][0]; i <= val[1][0]; i++)
                for (int j = val[0][1]; j <= val[1][1]; j++)
                    if (targetGrid[i][j] != key)
                        father.add(targetGrid[i][j]);
            map.put(key, father);
        });
        int[] state = new int[61];
        return IntStream.rangeClosed(1, 60).filter(i -> state[i] == 0 && bound.containsKey(i)).noneMatch(i -> f(i, state, map));
    }

    private boolean f(int ptr, int[] state, Map<Integer, Set<Integer>> map) {
        Set<Integer> st = map.getOrDefault(ptr, new HashSet<>());
        state[ptr] = 1;
        for (int v : st) {
            if (state[v] == 1) return true;
            else if (state[v] == 2) continue;
            if (f(v, state, map)) return true;
        }
        state[ptr] = 2;
        return false;
    }
}
