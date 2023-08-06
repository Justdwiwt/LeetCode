package main.java;

import java.util.Random;
import java.util.stream.IntStream;

public class Solution_496 {
    static class Solution {

        private final int[] sum;

        private final Random random;

        private final int[][] rects;

        private final int n;

        public Solution(int[][] rects) {
            this.rects = rects;
            this.n = rects.length;
            this.random = new Random();
            int mx = 110;
            this.sum = new int[mx];
            IntStream.rangeClosed(1, n).forEach(i -> {
                int[] rect = rects[i - 1];
                sum[i] = sum[i - 1] + (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            });
        }

        public int[] pick() {
            int p = 1 + random.nextInt(sum[n]);
            int i = find(p);
            int id = p - sum[i - 1] - 1;
            int m = rects[i - 1][2] - rects[i - 1][0] + 1;
            int dy = id / m, dx = id % m;
            return new int[]{rects[i - 1][0] + dx, rects[i - 1][1] + dy};
        }

        private int find(int x) {
            int lo = 1, hi = n, res = -1;
            while (lo <= hi) {
                int mid = (lo + hi) >>> 1;
                int val = sum[mid];
                if (x > val) lo = mid + 1;
                else {
                    res = mid;
                    hi = mid - 1;
                }
            }

            return res;
        }
    }
}
