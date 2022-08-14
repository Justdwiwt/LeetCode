package main.java;

import java.util.stream.IntStream;

public class Solution_1997 {
    public int firstDayBeenInAllRooms(int[] A) {
        final int M = (int) 1e9 + 7;
        int[] pre = new int[A.length];
        IntStream.range(1, A.length).forEach(i -> pre[i] = (pre[i - 1] + 1 + (pre[i - 1] - pre[A[i - 1]] + M) % M + 1) % M);
        return pre[A.length - 1];
    }
}
