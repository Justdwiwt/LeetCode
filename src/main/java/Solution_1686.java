package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_1686 {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int[][] value = IntStream.range(0, aliceValues.length).mapToObj(i -> new int[]{aliceValues[i], bobValues[i]}).toArray(int[][]::new);
        Arrays.sort(value, (a, b) -> b[0] + b[1] - a[1] - a[0]);
        int a = 0, b = 0;
        for (int i = 0; i < aliceValues.length; i++)
            if ((i & 1) == 0) a += value[i][0];
            else b += value[i][1];
        return Integer.compare(a, b);
    }
}
