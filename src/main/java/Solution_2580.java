package main.java;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_2580 {
    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, Comparator.comparingInt(a -> a[0]));
        int r = -1, res = 1;
        for (int[] range : ranges) {
            res = range[0] > r ? (res << 1) % 1000000007 : res;
            r = Math.max(range[1], r);
        }
        return res;
    }
}
