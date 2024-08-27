package main.java;

import java.util.stream.IntStream;

public class Solution_2305 {
    int res = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        f(cookies, new int[k], 0);
        return res;
    }

    public void f(int[] cookies, int[] sum, int index) {
        if (index >= cookies.length) {
            int max = Integer.MIN_VALUE;
            for (int j : sum) max = Math.max(max, j);
            res = max;
            return;
        }
        IntStream.range(0, sum.length).forEach(i -> {
            sum[i] += cookies[index];
            if (sum[i] < res) f(cookies, sum, index + 1);
            sum[i] -= cookies[index];
        });
    }
}
