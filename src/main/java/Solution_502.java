package main.java;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution_502 {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        if (Profits.length < 1) return W;
        PriorityQueue<int[]> pqCap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> pqPro = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        IntStream.range(0, Profits.length).mapToObj(i -> new int[]{Capital[i], Profits[i]}).forEach(pqCap::offer);
        while (k-- != 0) {
            while (!pqCap.isEmpty() && pqCap.peek()[0] <= W) pqPro.offer(pqCap.poll());
            if (pqPro.isEmpty()) break;
            W += pqPro.poll()[1];
        }
        return W;
    }
}
