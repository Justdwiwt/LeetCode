package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_1921 {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int len = dist.length;
        int[] time = new int[len];
        IntStream.range(0, len).forEach(i -> {
            time[i] = dist[i] / speed[i];
            if (dist[i] % speed[i] != 0) time[i]++;
        });
        Arrays.sort(time);

        return IntStream.range(0, len)
                .filter(i -> time[i] < i + 1)
                .findFirst()
                .orElse(len);
    }
}
