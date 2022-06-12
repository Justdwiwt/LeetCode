package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2279 {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        IntStream.range(0, rocks.length).forEach(i -> rocks[i] = capacity[i] - rocks[i]);
        Arrays.sort(rocks);
        int res = 0;
        for (int i : rocks)
            if (additionalRocks - i >= 0) {
                ++res;
                additionalRocks -= i;
            }
        return res;
    }
}
