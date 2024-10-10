package main.java;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_2355 {
    public long maximumBooks(int[] books) {
        int n = books.length;
        long res = 0;
        long[] dp = new long[n];
        dp[0] = books[0];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && books[stack.peek()] - stack.peek() > books[i] - i)
                stack.pop();
            int j = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
            int count = Math.min(i - j, books[i]);
            long sum = (long) ((books[i] - count + 1) + books[i]) * count / 2;
            dp[i] = sum + (j == -1 ? 0 : dp[j]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
