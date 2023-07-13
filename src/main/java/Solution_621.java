package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_621 {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        IntStream.range(0, tasks.length).forEach(i -> count[tasks[i] - 'A']++);
        Arrays.sort(count);
        int maxCount = 0;
        for (int i = 25; i >= 0; i--) {
            if (count[i] != count[25]) break;
            maxCount++;
        }
        return Math.max((count[25] - 1) * (n + 1) + maxCount, tasks.length);
    }
}
