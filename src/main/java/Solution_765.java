package main.java;

import java.util.stream.IntStream;

public class Solution_765 {
    public int minSwapsCouples(int[] row) {
        int[] pos = new int[row.length];
        IntStream.range(0, row.length).forEach(i -> pos[row[i]] = i);
        int res = 0;
        for (int i = 0; i < row.length; i += 2) {
            int need = row[i] ^ 1;
            int next = row[i + 1];
            if (next == need) continue;
            int index = pos[need];
            row[i + 1] = need;
            row[index] = next;
            pos[need] = i + 1;
            pos[next] = index;
            res++;
        }
        return res;
    }
}
