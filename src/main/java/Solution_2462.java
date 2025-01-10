package main.java;

import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_2462 {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> minT = new PriorityQueue<>();
        int headIndex = candidates - 1, tailIndex = Math.max(candidates, costs.length - candidates);
        PriorityQueue<Integer> minH = IntStream.rangeClosed(0, headIndex).mapToObj(i -> costs[i]).collect(Collectors.toCollection(PriorityQueue::new));
        for (int i = tailIndex; i < costs.length; i++)
            minT.add(costs[i]);
        long ans = 0;
        int pick = 0;
        while (pick < k) {
            if (!minH.isEmpty() && (minT.isEmpty() || minH.peek() <= minT.peek())) {
                ans += minH.poll();
                if (headIndex + 1 < tailIndex) {
                    headIndex++;
                    minH.add(costs[headIndex]);
                }
            } else {
                ans += minT.poll();
                if (tailIndex - 1 > headIndex) {
                    tailIndex--;
                    minT.add(costs[tailIndex]);
                }
            }
            pick++;
        }
        return ans;
    }
}
