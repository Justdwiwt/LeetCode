package main.java;

import java.util.*;
import java.util.stream.IntStream;

public class Solution_2493 {
    public int magnificentSets(int n, int[][] edges) {
        List<Integer>[] path = new List[n + 5];
        IntStream.rangeClosed(1, n).forEach(i -> path[i] = new ArrayList<>());
        IntStream.range(0, edges.length).forEach(i -> {
            path[edges[i][0]].add(edges[i][1]);
            path[edges[i][1]].add(edges[i][0]);
        });
        int res = 0;
        boolean[] has = new boolean[n + 5];
        for (int i = 1; i <= n; i++)
            if (!has[i]) {
                has[i] = true;
                int count = 0;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while (!q.isEmpty()) {
                    int a = q.poll();
                    int[] d = find(a, path);
                    if (d == null) return -1;
                    for (int j = 1; j <= n; j++) count = Math.max(count, d[j]);
                    path[a].stream().mapToInt(integer -> integer).filter(b -> !has[b]).forEach(b -> {
                        has[b] = true;
                        q.add(b);
                    });
                }
                res += count + 1;
            }
        return res;
    }

    int[] find(int k, List<Integer>[] path) {
        int[] ans = new int[path.length];
        Arrays.fill(ans, -1);
        ans[k] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        while (!q.isEmpty()) {
            int a = q.poll();
            for (int i = 0; i < path[a].size(); i++) {
                int b = path[a].get(i);
                if (ans[b] == -1) {
                    ans[b] = ans[a] + 1;
                    q.add(b);
                } else if (ans[b] % 2 == ans[a] % 2) return null;
            }
        }
        return ans;
    }
}
