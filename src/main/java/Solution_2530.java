package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_2530 {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(nums.length, Comparator.reverseOrder());
        Arrays.stream(nums).forEach(queue::add);
        long result = 0;
        for (int i = 0; i < k; i++) {
            int value = queue.poll();
            result += value;
            queue.add((value + 2) / 3);
        }
        return result;
    }
}
