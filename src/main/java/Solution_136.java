package main.java;

import java.util.Arrays;

public class Solution_136 {
    public int singleNumber(int[] nums) {
        return Arrays.stream(nums).reduce(0, (a, b) -> a ^ b);
    }
}
