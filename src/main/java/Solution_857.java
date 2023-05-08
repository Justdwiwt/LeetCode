package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution_857 {
    public double mincostToHireWorkers(int[] q, int[] w, int K) {
        double[][] workers = IntStream.range(0, q.length).mapToObj(i -> new double[]{(double) (w[i]) / q[i], (double) q[i]}).toArray(double[][]::new);
        Arrays.sort(workers, Comparator.comparingDouble(a -> a[0]));
        double res = Double.MAX_VALUE;
        double qsum = 0.0;
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for (double[] worker : workers) {
            qsum += worker[1];
            pq.add(-worker[1]);
            if (pq.size() > K) qsum += pq.poll();
            if (pq.size() == K) res = Math.min(res, qsum * worker[0]);
        }
        return res;
    }
}
