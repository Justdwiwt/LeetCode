package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_2438 {
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> arr = new ArrayList<>();
        int index = 0;
        while (n > 0) {
            if ((n & 1) == 1) arr.add(index);
            n >>= 1;
            index++;
        }
        int len = arr.size(), length = queries.length, mod = (int) 1e9 + 7;
        int[] pre = new int[len];
        IntStream.range(0, len).forEach(i -> {
            if (i == 0) pre[i] = arr.get(i);
            else pre[i] = pre[i - 1] + arr.get(i);
        });
        int[] res = new int[length];
        IntStream.range(0, length).forEach(i -> {
            if (queries[i][0] == 0)
                res[i] = pow(2, pre[queries[i][1]], mod);
            else
                res[i] = pow(2, pre[queries[i][1]] - pre[queries[i][0] - 1], mod);
        });
        return res;
    }

    private int pow(long a, int b, int mod) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1)
                res = (res * a) % mod;
            b >>= 1;
            a = (a * a) % mod;
        }
        return (int) res;
    }
}
