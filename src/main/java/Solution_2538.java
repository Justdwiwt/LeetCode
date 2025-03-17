package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_2538 {
    long ans = 0;

    public long maxOutput(int n, int[][] edges, int[] price) {
        List<Integer> path[] = IntStream.range(0, n).<List<Integer>>mapToObj(i -> new ArrayList<>()).toArray(List[]::new);
        Arrays.stream(edges).forEach(e -> {
            path[e[0]].add(e[1]);
            path[e[1]].add(e[0]);
        });
        find(0, path, price);
        return ans;
    }

    long[] find(int k, List<Integer> path[], int price[]) {
        int p = price[k];
        price[k] = -1;
        long ans1 = p, ans2 = 0;
        for (int a : path[k])
            if (price[a] != -1) {
                long son[] = find(a, path, price);
                ans = Math.max(ans, Math.max(ans1 + son[1], ans2 + son[0]));
                ans1 = Math.max(ans1, son[0] + p);
                ans2 = Math.max(ans2, son[1] + p);
            }
        return new long[]{ans1, ans2};
    }
}
