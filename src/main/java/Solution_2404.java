package main.java;

import java.util.*;

public class Solution_2404 {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> Objects.equals(a.getValue(), b.getValue()) ? a.getKey() - b.getKey() : b.getValue() - a.getValue());
        Arrays.stream(nums).filter(i -> i % 2 == 0).forEach(i -> map.put(i, map.getOrDefault(i, 0) + 1));
        map.entrySet().forEach(queue::offer);
        return queue.isEmpty() ? -1 : queue.peek().getKey();
    }
}
