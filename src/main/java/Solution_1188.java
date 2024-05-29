package main.java;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_1188 {
    static class BoundedBlockingQueue {
        Queue<Integer> q;
        final int capacity;

        public BoundedBlockingQueue(int capacity) {
            this.capacity = capacity;
            q = new ArrayDeque<>();
        }

        public void enqueue(int element) throws InterruptedException {
            synchronized (q) {
                while (q.size() == capacity) {
                    q.wait();
                }
                q.offer(element);
                q.notifyAll();
            }
        }

        public int dequeue() throws InterruptedException {
            int val;
            synchronized (q) {
                while (q.isEmpty()) {
                    q.wait();
                }
                val = q.poll();
                q.notifyAll();
            }
            return val;
        }

        public int size() {
            return q.size();
        }
    }
}
