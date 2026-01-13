package main.java;

import java.util.Arrays;

public class Solution_2980 {
    public boolean hasTrailingZeros(int[] nums) {
        int cnt = Arrays.stream(nums).map(x -> Integer.numberOfTrailingZeros(x) > 0 ? 1 : 0).sum();
        return cnt >= 2;
    }
}
