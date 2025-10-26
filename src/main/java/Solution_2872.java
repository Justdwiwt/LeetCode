package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_2872 {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<Integer>[] path = IntStream.range(0, n).<List<Integer>>mapToObj(i -> new ArrayList<>()).toArray(List[]::new);
        Arrays.stream(edges).forEach(e -> {
            path[e[0]].add(e[1]);
            path[e[1]].add(e[0]);
        });
        return 1 + find(0, path, k, new boolean[n], values);
    }

    int find(int p, List<Integer>[] path, int k, boolean[] has, int[] values) {
        has[p] = true;
        int ans = 0;
        for (int a : path[p])
            if (!has[a]) {
                ans += find(a, path, k, has, values);
                if (values[a] % k == 0) ans++;
                values[p] = (values[p] + values[a]) % k;
            }
        return ans;
    }
}
