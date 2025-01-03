package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution_2454 {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        LinkedList<Integer> s = new LinkedList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(x -> nums[x]));
        IntStream.range(0, n).forEach(i -> {
            while (!q.isEmpty() && nums[q.peek()] < nums[i]) ans[q.poll()] = nums[i];
            while (!s.isEmpty() && nums[i] > nums[s.peek()]) q.offer(s.pollFirst());
            s.offerFirst(i);
        });
        return ans;
    }
}
