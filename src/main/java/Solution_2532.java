package main.java;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution_2532 {
    public int findCrossingTime(int n, int k, int[][] time) {
        int curTime = 0;
        PriorityQueue<Worker> leftQueue = new PriorityQueue<>();
        PriorityQueue<Worker> pickQueue = new PriorityQueue<>(Comparator.comparingInt(w -> w.finishedTime));
        PriorityQueue<Worker> rightQueue = new PriorityQueue<>();
        PriorityQueue<Worker> putQueue = new PriorityQueue<>(Comparator.comparingInt(w -> w.finishedTime));
        IntStream.range(0, k).mapToObj(i -> new Worker(i, time)).forEach(leftQueue::offer);
        while (n > 0 || !pickQueue.isEmpty() || !rightQueue.isEmpty()) {
            if (!rightQueue.isEmpty()) {
                Worker worker = rightQueue.poll();
                int costTime = time[worker.index][2];
                curTime += costTime;
                worker.finishedTime = curTime + time[worker.index][3];
                putQueue.offer(worker);
            } else if (!leftQueue.isEmpty() && n > 0) {
                Worker worker = leftQueue.poll();
                int costTime = time[worker.index][0];
                curTime += costTime;
                worker.finishedTime = curTime + time[worker.index][1];
                pickQueue.offer(worker);
                n--;
            } else curTime = Math.min(pickQueue.isEmpty() ? Integer.MAX_VALUE : pickQueue.peek().finishedTime,
                    putQueue.isEmpty() ? Integer.MAX_VALUE : putQueue.peek().finishedTime);
            while (!pickQueue.isEmpty() && pickQueue.peek().finishedTime <= curTime)
                rightQueue.offer(pickQueue.poll());
            while (!putQueue.isEmpty() && putQueue.peek().finishedTime <= curTime)
                leftQueue.offer((putQueue.poll()));
        }
        return curTime;
    }

    private class Worker implements Comparable<Worker> {
        int index;
        int efficiency;
        int finishedTime;

        public Worker(int index, int[][] time) {
            this.index = index;
            this.finishedTime = 0;
            this.efficiency = -(time[index][0] + time[index][2]);
        }

        @Override
        public int compareTo(Worker another) {
            return efficiency == another.efficiency ? another.index - index : efficiency - another.efficiency;
        }
    }
}
