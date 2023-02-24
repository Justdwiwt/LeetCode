package main.java;

import java.util.stream.IntStream;

public class Solution_1124 {
    public int longestWPI(int[] hours) {
        int n = hours.length, max = 0;
        int[] arr = new int[n + 1];
        IntStream.range(0, n).forEach(i -> arr[i + 1] = arr[i] + (hours[i] > 8 ? 1 : -1));
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= i; j++)
                if (arr[i] > arr[j]) max = Math.max(max, i - j);
        return max;
    }
}
