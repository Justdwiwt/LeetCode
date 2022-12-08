package main.java;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_1475 {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] res = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!deque.isEmpty() && deque.getLast() > prices[i]) deque.pollLast();
            res[i] = deque.isEmpty() ? prices[i] : prices[i] - deque.getLast();
            deque.addLast(prices[i]);
        }
        return res;
    }
}
