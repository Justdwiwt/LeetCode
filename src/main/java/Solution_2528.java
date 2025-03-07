package main.java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Solution_2528 {
    public long maxPower(int[] stations, int r, int k) {
        long[] diff = new long[stations.length];
        IntStream.range(0, stations.length).forEach(i -> {
            int st = Math.max(0, i - r);
            diff[st] += stations[i];
            if (i + r + 1 < diff.length) diff[i + r + 1] -= stations[i];
        });
        long[] cnt = new long[stations.length];
        cnt[0] = diff[0];
        IntStream.range(1, cnt.length).forEach(i -> cnt[i] += cnt[i - 1] + diff[i]);
        long left = 0, right = (long) 1e15, mid;
        while (left < right) {
            mid = left + (right - left + 1) / 2;
            Queue<long[]> q = new LinkedList<>();
            long acc = 0, need = 0;
            for (int i = 0; i < stations.length; i++) {
                while (!q.isEmpty() && q.peek()[0] + r < i) acc -= q.poll()[1];
                if (cnt[i] + acc < mid) {
                    long n = mid - cnt[i] - acc;
                    need += n;
                    acc += n;
                    q.offer(new long[]{i + r, n});
                }
                if (need > k) break;
            }
            if (need > k) right = mid - 1;
            else left = mid;
        }
        return left;
    }
}
