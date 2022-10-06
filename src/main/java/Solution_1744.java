package main.java;

import java.util.stream.IntStream;

public class Solution_1744 {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        boolean[] res = new boolean[queries.length];
        long[] tmp = new long[candiesCount.length];
        tmp[0] = candiesCount[0];
        IntStream.range(1, candiesCount.length).forEach(i -> tmp[i] = tmp[i - 1] + candiesCount[i]);
        IntStream.range(0, res.length).forEach(i -> {
            if ((queries[i][1] + 1) > tmp[queries[i][0]])
                res[i] = false;
            else
                res[i] = ((long) queries[i][1] + 1) * (long) queries[i][2] > tmp[queries[i][0]] - candiesCount[queries[i][0]];
        });
        return res;
    }
}
