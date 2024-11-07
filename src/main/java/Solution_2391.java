package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2391 {
    public int garbageCollection(String[] garbage, int[] travel) {
        int res = 0;
        int len = garbage.length;
        int[] ch = new int[]{'P', 'G', 'M'};
        if (len == 0) return 0;
        for (int i = 0; i < 3; i++)
            for (int j = len - 1; j >= 0; j--)
                if (garbage[j].indexOf(ch[i]) != -1) {
                    res += Arrays.stream(travel, 0, j).sum();
                    break;
                }
        res += IntStream.range(0, len).map(i -> garbage[i].length()).sum();
        return res;
    }
}
