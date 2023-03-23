package main.java;

import java.util.stream.IntStream;

public class Solution_997 {
    public int findJudge(int n, int[][] trust) {
        int[] aux = new int[n + 1];
        IntStream.range(0, trust.length).forEach(i -> {
            aux[trust[i][1]]++;
            aux[trust[i][0]]--;
        });
        return IntStream.rangeClosed(1, n).filter(i -> aux[i] == n - 1).findFirst().orElse(-1);
    }
}
