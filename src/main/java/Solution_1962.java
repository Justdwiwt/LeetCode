package main.java;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution_1962 {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        Arrays.stream(piles).forEach(pq::offer);
        IntStream.range(0, k).forEach(i -> pq.offer(pq.peek() - pq.poll() / 2));
        int res = 0;
        while (!pq.isEmpty()) res += pq.poll();
        return res;
    }
}
