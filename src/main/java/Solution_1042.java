package main.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_1042 {
    public int[] gardenNoAdj(int N, int[][] paths) {
        Map<Integer, Set<Integer>> graph = IntStream.range(0, N).boxed().collect(Collectors.toMap(i -> i, i -> new HashSet<>(), (a, b) -> b));
        Arrays.stream(paths).forEach(path -> {
            graph.get(path[0] - 1).add(path[1] - 1);
            graph.get(path[1] - 1).add(path[0] - 1);
        });
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            boolean[] used = new boolean[5];
            graph.get(i).forEach(adj -> used[res[adj]] = true);
            for (int j = 1; j <= 4; j++)
                if (!used[j]) res[i] = j;
        }
        return res;
    }
}
