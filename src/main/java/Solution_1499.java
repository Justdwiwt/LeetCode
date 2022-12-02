package main.java;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_1499 {
    public int findMaxValueOfEquation(int[][] A, int k) {
        Deque<int[]> deque = new LinkedList<>();
        int res = Integer.MIN_VALUE;
        for (int[] arr : A) {
            while (!deque.isEmpty() && arr[0] - deque.peekFirst()[0] > k)
                deque.pollFirst();
            if (!deque.isEmpty())
                res = Math.max(res, arr[0] + arr[1] + deque.peekFirst()[1] - deque.peekFirst()[0]);
            while (!deque.isEmpty() && deque.peekLast()[1] - deque.peekLast()[0] <= arr[1] - arr[0])
                deque.pollLast();
            deque.offerLast(arr);
        }
        return res;
    }
}
