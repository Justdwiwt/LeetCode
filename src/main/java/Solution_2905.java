package main.java;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_2905 {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        PriorityQueue<Integer> smaller = new PriorityQueue<>(Comparator.comparingInt(o -> nums[o]));
        PriorityQueue<Integer> bigger = new PriorityQueue<>((o1, o2) -> nums[o2] - nums[o1]);
        for (int i = indexDifference; i < nums.length; i++) {
            smaller.offer(i - indexDifference);
            bigger.offer(i - indexDifference);
            if (nums[i] - nums[smaller.peek()] >= valueDifference) return new int[]{smaller.peek(), i};
            if (nums[bigger.peek()] - nums[i] >= valueDifference) return new int[]{bigger.peek(), i};
        }
        return new int[]{-1, -1};
    }
}
