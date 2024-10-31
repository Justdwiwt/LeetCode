package main.java;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Solution_2382 {
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        int n = nums.length;
        long[] res = new long[n];
        long[] prefixSum = new long[n + 1];
        IntStream.rangeClosed(1, n).forEach(i -> prefixSum[i] = prefixSum[i - 1] + nums[i - 1]);
        TreeMap<Integer, Segment> treeMap = new TreeMap<>();
        Segment total = new Segment(0, n - 1, prefixSum[n]);
        treeMap.put(0, total);
        Queue<Segment> queue = new PriorityQueue<>((o1, o2) -> Long.compare(o2.sum, o1.sum));
        queue.offer(total);
        IntStream.range(0, n - 1).forEach(i -> {
            int removeIndex = removeQueries[i];
            Integer start = treeMap.floorKey(removeIndex);
            Segment segment = treeMap.get(start);
            long sum1 = prefixSum[removeIndex] - prefixSum[start];
            long sum2 = segment.sum - sum1 - nums[removeIndex];
            treeMap.remove(start, segment);
            Segment segment1 = new Segment(start, removeIndex - 1, sum1);
            Segment segment2 = new Segment(removeIndex + 1, segment.end, sum2);
            treeMap.put(start, segment1);
            treeMap.put(removeIndex + 1, segment2);
            queue.offer(segment1);
            queue.offer(segment2);
            segment.valid = false;
            while (!queue.isEmpty() && !queue.peek().valid) queue.remove();
            if (queue.peek() != null) res[i] = queue.peek().sum;
        });
        return res;
    }
}

class Segment {
    int start;
    int end;
    long sum;
    boolean valid;

    public Segment(int start, int end, long sum) {
        this.start = start;
        this.end = end;
        this.sum = sum;
        this.valid = true;
    }
}
