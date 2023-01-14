package main.java;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

public class Solution_1326 {
    public int minTaps(int n, int[] ranges) {
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        IntStream.rangeClosed(0, n).mapToObj(i -> new int[]{Math.max(0, i - ranges[i]), Math.min(n, i + ranges[i])}).forEach(q::add);
        int max = 0, res = 0;
        while (max < n) {
            if (q.size() == 0 || q.peek()[0] > max) return -1;
            int r = max;
            while (q.size() > 0 && q.peek()[0] <= max) r = Math.max(r, q.poll()[1]);
            if (r > max) {
                res++;
                max = r;
            }
        }
        return res;
    }
}
