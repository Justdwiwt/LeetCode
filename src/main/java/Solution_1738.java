package main.java;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_1738 {
    public int kthLargestValue(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] sum = new int[m + 1][n + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] ^ sum[i][j - 1] ^ sum[i - 1][j - 1] ^ mat[i - 1][j - 1];
                if (pq.size() < k) pq.add(sum[i][j]);
                else if (sum[i][j] > pq.peek()) {
                    pq.poll();
                    pq.add(sum[i][j]);
                }
            }
        return pq.peek();
    }
}
