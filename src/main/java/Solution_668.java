package main.java;

import java.util.stream.IntStream;

public class Solution_668 {
    public int findKthNumber(int m, int n, int k) {
        int l = 1, r = m * n;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (countLess(m, n, mid) < k) l = mid + 1;
            else r = mid;
            if (l == r - 1) {
                if (countLess(m, n, l) >= k) r = l;
                break;
            }
        }
        return r;
    }

    public int countLess(int m, int n, int max) {
        return IntStream.rangeClosed(1, n).map(i -> Math.min(m, max / i)).sum();
    }
}
