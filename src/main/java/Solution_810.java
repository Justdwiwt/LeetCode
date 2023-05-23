package main.java;

import java.util.Arrays;

public class Solution_810 {
    public boolean xorGame(int[] nums) {
        return (nums.length & 1) == 0 || Arrays.stream(nums).reduce(0, (i1, i2) -> i1 ^ i2) == 0;
    }
}
