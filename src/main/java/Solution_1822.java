package main.java;

import java.util.Arrays;

public class Solution_1822 {
    public int arraySign(int[] nums) {
        return Arrays.stream(nums)
                .map(num -> Integer.compare(num, 0))
                .reduce(1, (a, b) -> a * b);
    }
}
