package main.java;

import java.util.Arrays;

public class Solution_179 {
    public String largestNumber(int[] nums) {
        return Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .sorted((a, b) -> (b + a).compareTo(a + b))
                .reduce("", (o, n) -> "0".equals(o) && "0".equals(n) ? "0" : o + n);
    }
}
