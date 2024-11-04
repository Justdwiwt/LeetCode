package main.java;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_2386 {
    public long kSum(int[] nums, int k) {
        long sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++)
            if (nums[i] >= 0) sum += nums[i];
            else nums[i] = -nums[i];
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.offer(sum);
        Arrays.sort(nums);
        for (int num : nums) {
            PriorityQueue<Long> copy = new PriorityQueue<>(pq);
            boolean change = false;
            while (!copy.isEmpty()) {
                if (pq.size() < k || pq.peek() < copy.peek() - num) change = true;
                pq.offer(copy.poll() - num);
                if (pq.size() > k) pq.poll();
            }
            if (!change) break;
        }
        return pq.peek();
    }
}
