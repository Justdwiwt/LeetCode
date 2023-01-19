package main.java;

import java.util.stream.IntStream;

public class Solution_1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        IntStream.range(1, arr.length).forEach(i -> sum[i] = sum[i - 1] ^ arr[i]);
        int[] res = new int[queries.length];
        IntStream.range(0, queries.length).forEach(i -> res[i] = queries[i][0] == 0 ? sum[queries[i][1]] : sum[queries[i][1]] ^ sum[queries[i][0] - 1]);
        return res;
    }
}
