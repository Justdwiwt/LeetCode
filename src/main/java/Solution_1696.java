package main.java;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class Solution_1696 {
    public int maxResult(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        q.add(0);
        IntStream.range(1, nums.length).forEach(i -> {
            dp[i] = nums[i] + dp[q.peek()];
            while (!q.isEmpty() && dp[q.peekLast()] <= dp[i]) q.pollLast();
            q.addLast(i);
            if (i - k >= 0 && q.peek() == i - k) q.poll();
        });
        return dp[nums.length - 1];
    }
}
