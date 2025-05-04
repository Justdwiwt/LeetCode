package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Solution_2589 {
    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt(a -> a[1]));
        int[] sum = new int[2002];
        int n = tasks.length, cur = tasks[0][1];
        for (int[] t : tasks) {
            if (cur >= t[0]) {
                int v = t[2] - sum[cur] + sum[t[0] - 1];
                if (v <= 0) continue;
                int r = t[1] - cur;
                if (r >= v) {
                    r = t[1] - v;
                    for (int j = cur + 1; j <= r; j++) sum[j] = sum[cur];
                    IntStream.range(r, t[1]).forEach(j -> sum[j + 1] = sum[j] + 1);
                } else {
                    int j = cur;
                    for (; j < t[1]; j++)
                        sum[j + 1] = sum[cur];
                    while (v > 0) {
                        int p = sum[j];
                        sum[j] += v;
                        if (sum[j - 1] == p)
                            v--;
                        j--;
                    }
                }
            } else {
                int r = t[1] - t[2];
                for (int j = cur + 1; j <= r; j++) sum[j] = sum[cur];
                IntStream.range(r, t[1]).forEach(j -> sum[j + 1] = sum[j] + 1);
            }
            cur = t[1];
        }
        return sum[cur];
    }
}
