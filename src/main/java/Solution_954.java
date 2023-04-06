package main.java;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution_954 {
    public boolean canReorderDoubled(int[] arr) {
        Deque<Integer> deque = new LinkedList<>();
        arr = Arrays.stream(arr).boxed().sorted((a, b) -> {
            if (a < 0 && b < 0) return b - a;
            else return a - b;
        }).mapToInt(Integer::intValue).toArray();
        Arrays.stream(arr).forEach(v -> {
            if (v % 2 == 0 && !deque.isEmpty() && deque.peek() == v / 2) deque.pop();
            else deque.offer(v);
        });
        return deque.isEmpty();
    }
}
