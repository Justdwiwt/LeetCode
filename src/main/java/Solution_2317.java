package main.java;

import java.util.Arrays;

public class Solution_2317 {
    public int maximumXOR(int[] nums) {
        return Arrays.stream(nums).reduce(0, (a, b) -> a | b);
    }
}
