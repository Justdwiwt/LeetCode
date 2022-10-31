package main.java;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.naturalOrder());
        int cur = 0;
        for (int i = 1; i < heights.length; i++) {
            int diff = heights[i] - heights[i - 1];
            if (diff <= 0) continue;
            pq.add(diff);
            if (pq.size() > ladders) cur += pq.poll();
            if (cur > bricks) return i - 1;
        }
        return heights.length - 1;
    }
}
