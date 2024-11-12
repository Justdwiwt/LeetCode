package main.java;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_2398 {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length, maxCnt = 0;
        long sum = 0;
        Deque<Integer> maxId = new ArrayDeque<>();
        for (int l = 0, r = 0; r < n; r++) {
            sum += runningCosts[r];
            while (!maxId.isEmpty() && chargeTimes[r] >= chargeTimes[maxId.peekLast()]) maxId.pollLast();
            maxId.addLast(r);
            if ((long) (r - l + 1) * sum + chargeTimes[maxId.peekFirst()] > budget) {
                sum -= runningCosts[l++];
                if (maxId.peekFirst() < l) maxId.pollFirst();
            }
            maxCnt = Math.max(maxCnt, r - l + 1);
        }
        return maxCnt;
    }
}
