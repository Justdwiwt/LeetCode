package main.java;

public class Solution_440 {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k--;
        while (k > 0) {
            long step = 0, first = cur, last = cur + 1;
            while (first <= n) {
                step += Math.min(last, n + 1) - first;
                first *= 10;
                last *= 10;
            }
            if (step > k) {
                k--;
                cur *= 10;
            }
            if (step <= k) {
                k -= step;
                ++cur;
            }
        }
        return cur;
    }
}
