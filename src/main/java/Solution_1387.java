package main.java;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

public class Solution_1387 {
    public int getKth(int lo, int hi, int k) {
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] != o2[1] ? o2[1] - o1[1] : o2[0] - o1[0]);
        IntStream.rangeClosed(lo, hi).forEach(i -> {
            queue.offer(new int[]{i, getP(i)});
            if (i - lo + 1 > k) queue.poll();
        });
        return queue.poll()[0];
    }

    private int getP(int x) {
        int c = 0;
        while (x != 1) {
            if ((x & 1) == 1) x += (x << 1) + 1;
            else x >>= 1;
            ++c;
        }
        return c;
    }
}
