package main.java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_2866 {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long[] left = new long[n], right = new long[n];
        long ans = 0L;
        Deque<Integer> deque = new ArrayDeque<>();
        IntStream.range(0, n).forEach(i -> {
            while (!deque.isEmpty() && maxHeights.get(deque.getLast()) >= maxHeights.get(i)) deque.pollLast();
            left[i] = deque.isEmpty() ? (long) maxHeights.get(i) * (i + 1) : left[deque.getLast()] + (long) maxHeights.get(i) * (i - deque.getLast());
            deque.addLast(i);
        });
        deque.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!deque.isEmpty() && maxHeights.get(deque.getLast()) >= maxHeights.get(i)) deque.pollLast();
            right[i] = deque.isEmpty() ? (long) maxHeights.get(i) * (n - i) : right[deque.getLast()] + (long) maxHeights.get(i) * (deque.getLast() - i);
            ans = Math.max(ans, left[i] + right[i] - maxHeights.get(i));
            deque.addLast(i);
        }
        return ans;
    }
}
