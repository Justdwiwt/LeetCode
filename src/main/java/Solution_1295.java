package main.java;

import java.util.Arrays;

public class Solution_1295 {
    public int findNumbers(int[] nums) {
        return Arrays.stream(nums)
                .map(num -> String.valueOf(num).length() % 2 == 0 ? 1 : 0)
                .sum();
    }
}
