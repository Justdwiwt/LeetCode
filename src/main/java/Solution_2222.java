package main.java;

import java.util.stream.IntStream;

public class Solution_2222 {
    public long numberOfWays(String s) {
        int n = s.length();
        long ways = 0L;
        int[] pre = new int[n];
        pre[0] = s.charAt(0) == '0' ? 1 : 0;
        IntStream.range(1, n).forEach(i -> pre[i] = pre[i - 1] + (s.charAt(i) == '0' ? 1 : 0));
        for (int i = 1; i < n - 1; i++)
            if (s.charAt(i) == '0') ways += (long) (i - pre[i - 1]) * (n - 1 - i - (pre[n - 1] - pre[i]));
            else ways += (long) pre[i - 1] * (pre[n - 1] - pre[i]);
        return ways;
    }
}
