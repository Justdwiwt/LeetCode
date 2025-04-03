package main.java;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_2558 {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        Arrays.stream(gifts).forEach(pq::offer);
        while (k-- > 0) pq.offer((int) Math.sqrt(pq.poll()));
        long ans = 0;
        while (!pq.isEmpty()) ans += pq.poll();
        return ans;
    }
}
