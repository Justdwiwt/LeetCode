package main.java;

import java.util.*;
import java.util.stream.IntStream;

public class Solution_2492 {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] path = new List[n + 5];
        IntStream.rangeClosed(1, n).forEach(i -> path[i] = new ArrayList<>());
        Arrays.stream(roads).forEach(road -> {
            path[road[0]].add(new int[]{road[1], road[2]});
            path[road[1]].add(new int[]{road[0], road[2]});
        });
        boolean[] has = new boolean[n + 5];
        has[1] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int ans = (int) 1e5;
        while (!q.isEmpty()) {
            int a = q.poll();
            for (int i = 0; i < path[a].size(); i++) {
                int[] b = path[a].get(i);
                ans = Math.min(ans, b[1]);
                if (has[b[0]]) continue;
                has[b[0]] = true;
                q.add(b[0]);
            }
        }
        return ans;
    }
}
