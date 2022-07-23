package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2094 {
    public static int[] cnt;

    public static int[] findEvenNumbers(int[] digits) {
        cnt = new int[10];
        Arrays.stream(digits).forEach(d -> cnt[d]++);
        return IntStream.range(100, 999)
                .filter(num -> num % 2 == 0)
                .filter(Solution_2094::matcher)
                .toArray();

    }

    private static boolean matcher(int num) {
        int[] cnt = new int[10];
        while (num > 0) {
            cnt[num % 10]++;
            num /= 10;
        }
        return doesItContains(cnt);
    }

    private static boolean doesItContains(int[] cnt) {
        return IntStream.range(0, 10).allMatch(d -> cnt[d] <= Solution_2094.cnt[d]);
    }
}
