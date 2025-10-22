package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_2867 {
    private static final int N = 100001;
    private static final boolean[] isprime = new boolean[N];

    static {
        Arrays.fill(isprime, true);
        isprime[1] = false;
        for (int i = 2; i * i < N; i++)
            if (isprime[i]) for (int j = i * i; j < N; j += i) isprime[j] = false;
    }

    public long countPaths(int n, int[][] edges) {
        List<Integer>[] G = new ArrayList[n + 1];
        IntStream.rangeClosed(0, n).forEach(i -> G[i] = new ArrayList<>());

        Arrays.stream(edges).forEach(edge -> {
            int i = edge[0], j = edge[1];
            G[i].add(j);
            G[j].add(i);
        });

        List<Integer> seen = new ArrayList<>();
        long res = 0;
        long[] count = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!isprime[i]) continue;
            long cur = 0;
            for (int j : G[i]) {
                if (isprime[j]) continue;
                if (count[j] == 0) {
                    seen.clear();
                    dfs(G, seen, j, 0);
                    long cnt = seen.size();
                    seen.forEach(k -> count[k] = cnt);
                }
                res += count[j] * cur;
                cur += count[j];
            }
            res += cur;
        }
        return res;
    }

    private void dfs(List<Integer>[] G, List<Integer> seen, int i, int pre) {
        seen.add(i);
        G[i].stream().mapToInt(j -> j).filter(j -> j != pre && !isprime[j]).forEach(j -> dfs(G, seen, j, i));
    }
}
