package main.java;

import java.util.stream.IntStream;

public class Solution_1466 {
    public int minReorder(int n, int[][] connections) {
        int res = 0;
        boolean[] flags = new boolean[n];
        flags[0] = true;
        while (!alltoZero(flags)) {
            for (int[] connection : connections)
                if (flags[connection[0]] && !flags[connection[1]]) {
                    flags[connection[1]] = true;
                    res++;
                } else if (!flags[connection[0]] && flags[connection[1]])
                    flags[connection[0]] = true;
        }
        return res;
    }

    private boolean alltoZero(boolean[] flags) {
        return IntStream.range(0, flags.length).allMatch(i -> flags[i]);
    }
}
