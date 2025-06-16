package main.java;

import java.util.*;
import java.util.stream.IntStream;

public class Solution_2662 {
    public int minimumCost(int[] start, int[] target, int[][] arr) {
        int n = arr.length;
        int[][] aa = new int[n * 2][];
        IntStream.range(0, n).forEach(i -> {
            aa[i] = arr[i];
            aa[i + n] = new int[]{aa[i][2], aa[i][3], target[0], target[1], Math.abs(aa[i][2] - target[0]) + Math.abs(aa[i][3] - target[1])};
        });
        int base = (int) 1e5;
        Map<Long, Integer> map = new HashMap<>();
        map.put((long) start[0] * base + start[1], 0);
        map.put((long) target[0] * base + target[1], target[0] - start[0] + target[1] - start[1]);
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        q.offer(new int[]{start[0], start[1], 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], t = cur[2];
            if (x == target[0] && y == target[1]) return t;
            if (t > map.getOrDefault((long) x * base + y, Integer.MAX_VALUE)) continue;
            Arrays.stream(aa, 0, 2 * n).forEach(cc -> {
                int xx = cc[0], yy = cc[1], xxx = cc[2], yyy = cc[3], tt = cc[4];
                if (t + tt + Math.abs(x - xx) + Math.abs(y - yy) < map.getOrDefault((long) xxx * base + yyy, Integer.MAX_VALUE)) {
                    map.put((long) xxx * base + yyy, t + tt + Math.abs(x - xx) + Math.abs(y - yy));
                    q.offer(new int[]{xxx, yyy, t + tt + Math.abs(x - xx) + Math.abs(y - yy)});
                }
            });
        }
        return map.get((long) target[0] * base + target[1]);
    }
}
