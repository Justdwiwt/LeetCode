package main.java;

import java.util.Arrays;

public class Solution_2455 {
    public int averageValue(int[] nums) {
        return (int) Arrays.stream(nums).filter(num -> num % 6 == 0).average().orElse(0.0);
    }
}
