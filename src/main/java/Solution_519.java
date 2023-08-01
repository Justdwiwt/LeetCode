package main.java;

public class Solution_519 {
    static class Solution {
        private int x;
        private final int m;
        private final int n;

        public Solution(int m, int n) {
            x = 0;
            this.m = m;
            this.n = n;
        }

        public int[] flip() {
            int[] res = new int[]{x / n, x % n};
            x++;
            if (x >= m * n) {
                x = 0;
            }
            return res;
        }

        public void reset() {
            return;
        }
    }
}
