package main.java;

import java.util.Arrays;

public class Solution_2587 {
    public int maxScore(int[] nums) {
        return (int) Arrays.stream(nums)
                .boxed()
                .sorted((a, b) -> Integer.compare(b, a))
                .reduce(new long[]{0L, 0L}, (acc, num) -> {
                    acc[0] += num;
                    if (acc[0] > 0) acc[1]++;
                    return acc;
                }, (acc1, acc2) -> null)[1];
    }
}
