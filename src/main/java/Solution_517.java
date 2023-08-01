package main.java;

import java.util.stream.IntStream;

public class Solution_517 {
    public int findMinMoves(int[] machines) {
        int n = machines.length;
        IntStream.range(1, n).forEach(i -> machines[i] += machines[i - 1]);
        if (machines[n - 1] % n != 0) return -1;
        int avg = machines[n - 1] / n;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int leftneed = avg * i;
            int rightneed = avg * (n - i - 1);
            int left = i > 0 ? machines[i - 1] : 0;
            int right = machines[n - 1] - machines[i];
            leftneed -= left;
            rightneed -= right;
            res = leftneed > 0 && rightneed > 0 ? Math.max(res, Math.abs(leftneed) + Math.abs(rightneed)) : Math.max(res, Math.max(Math.abs(leftneed), Math.abs(rightneed)));
        }
        return res;
    }
}
