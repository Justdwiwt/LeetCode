package main.java;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution_2542 {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        Object[] objects = IntStream.range(0, nums1.length).boxed().sorted(Comparator.comparingInt(index -> -nums2[index])).toArray();
        long sum = 0L, maxScore = 0L;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (Object object : objects) {
            sum += nums1[(int) object];
            queue.add(nums1[(int) object]);
            if (queue.size() > k) sum -= queue.poll();
            if (queue.size() == k) maxScore = Math.max(maxScore, sum * nums2[(int) object]);
        }
        return maxScore;
    }
}
