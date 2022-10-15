package main.java;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_1705 {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int res = 0, n = apples.length, k = 0;
        for (int i = 0; i < n; i++) {
            pq.add(new int[]{i + days[i], apples[i]});
            while (!pq.isEmpty() && pq.peek()[0] <= k) pq.poll();
            if (!pq.isEmpty()) {
                int[] p = pq.poll();
                if (--p[1] > 0) pq.add(p);
                res++;
            }
            k++;
        }
        while (!pq.isEmpty()) {
            while (!pq.isEmpty() && pq.peek()[0] <= k) pq.poll();
            if (pq.isEmpty()) return res;
            int[] p = pq.poll();
            if (--p[1] > 0) pq.add(p);
            res++;
            k++;
        }
        return res;
    }
}
