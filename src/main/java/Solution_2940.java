package main.java;

import java.util.*;
import java.util.stream.IntStream;

public class Solution_2940 {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);
        List<int[]>[] qs = new ArrayList[heights.length];
        Arrays.setAll(qs, i -> new ArrayList<>());

        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            if (a > b) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            if (a == b || heights[a] < heights[b]) ans[i] = b;
            else qs[b].add(new int[]{heights[a], i});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        IntStream.range(0, heights.length).forEach(i -> {
            while (!pq.isEmpty() && pq.peek()[0] < heights[i]) ans[pq.poll()[1]] = i;
            qs[i].forEach(pq::offer);
        });
        return ans;
    }
}
