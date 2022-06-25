package main.java;

import java.util.stream.IntStream;

public class Solution_2217 {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int prefix = (int) Math.pow(10, (intLength - 1) >> 1);
        long[] res = new long[queries.length];
        IntStream.range(0, queries.length).forEach(i -> {
            String str = String.valueOf(queries[i] + prefix - 1);
            String resStr = str + new StringBuilder(str.substring(0, intLength - (intLength + 1) / 2)).reverse();
            res[i] = resStr.length() > intLength ? -1 : Long.parseLong(resStr);
        });
        return res;
    }
}
