package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_1851 {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;
        int[] res = new int[n];

        List<int[]> list = IntStream.range(0, n)
                .mapToObj(i -> new int[]{queries[i], i})
                .collect(Collectors.toList());

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

        list.sort((o1, o2) -> Integer.compare(o2[0], o1[0]));

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1] - o[0]));

        int idx = intervals.length - 1;

        for (int i = 0; i < n; i++) {
            int[] cur = list.get(i);
            while (idx >= 0 && intervals[idx][1] >= cur[0]) q.offer(intervals[idx--]);
            while (!q.isEmpty() && q.peek()[0] > cur[0]) q.poll();
            res[cur[1]] = q.isEmpty() ? -1 : (q.peek()[1] - q.peek()[0] + 1);
        }

        return res;
    }
}
