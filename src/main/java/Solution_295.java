package main.java;

import java.util.PriorityQueue;

public class Solution_295 {
    static class MedianFinder {
        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;

        public MedianFinder() {
            maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (maxHeap.size() == minHeap.size()) {
                minHeap.offer(num);
                maxHeap.offer(minHeap.poll());
            } else {
                maxHeap.offer(num);
                minHeap.offer(maxHeap.poll());
            }
        }

        public double findMedian() {
            if (maxHeap.size() == minHeap.size()) return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
            else return maxHeap.peek();
        }
    }
}
