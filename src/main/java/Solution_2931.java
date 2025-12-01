package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution_2931 {
    public long maxSpending(int[][] values) {
        int m = values.length, n = values[0].length, d = 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        IntStream.range(0, m).mapToObj(i -> new int[]{i, values[i][n - 1]}).forEach(pq::add);
        long res = 0;
        int[] ans = new int[m];
        Arrays.fill(ans, n - 2);
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            res += (long) d * poll[1];
            if (ans[poll[0]] >= 0) {
                pq.add(new int[]{poll[0], values[poll[0]][ans[poll[0]]]});
                ans[poll[0]]--;
            }
            d++;
        }
        return res;
    }
}
