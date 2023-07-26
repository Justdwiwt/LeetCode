package main.java;

import java.util.Arrays;

public class Solution_540 {
    public int singleNonDuplicate(int[] nums) {
        return Arrays.stream(nums).reduce(0, (a, b) -> a ^ b);
    }
}
