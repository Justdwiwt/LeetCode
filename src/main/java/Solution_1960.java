package main.java;

import java.util.stream.IntStream;

public class Solution_1960 {
    private static final long base = 29L;
    private static final long M = Integer.MAX_VALUE;

    private boolean isPalindromic(int l, int r, long[] lh, long[] rh, long[] pow) {
        return lh(l, r, lh, pow) == rh(l, r, rh, pow);
    }

    private long lh(int l, int r, long[] hash, long[] pow) {
        long res = (hash[r] - hash[l] * pow[r - l]) % M;
        if (res < 0) res += M;
        return res;
    }

    private long rh(int l, int r, long[] hash, long[] pow) {
        long res = (hash[l] - hash[r] * pow[r - l]) % M;
        if (res < 0) res += M;
        return res;
    }

    public long maxProduct(String s) {
        int n = s.length();

        long[] pow = new long[n + 1];
        pow[0] = 1;
        IntStream.rangeClosed(1, n).forEach(i -> pow[i] = pow[i - 1] * base % M);

        long[] lh = new long[n + 1];
        IntStream.rangeClosed(1, n).forEach(i -> lh[i] = (lh[i - 1] * base + s.charAt(i - 1) - 'a') % M);

        long[] rh = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) rh[i] = (rh[i + 1] * base + s.charAt(i) - 'a') % M;

        int[] left = new int[n];
        for (int i = 0, max = 1; i < n; i++) {
            if (max < i && isPalindromic(i - max - 1, i + 1, lh, rh, pow)) max += 2;
            left[i] = max;
        }

        int[] right = new int[n];
        for (int i = n - 1, max = 1; i >= 0; i--) {
            if (i + max + 2 <= n && isPalindromic(i, i + max + 2, lh, rh, pow)) max += 2;
            right[i] = max;
        }

        long res = 1;
        for (int i = 1; i < n; i++) res = Math.max(res, (long) left[i - 1] * right[i]);
        return res;
    }
}
