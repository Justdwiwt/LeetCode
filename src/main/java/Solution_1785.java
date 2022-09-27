package main.java;

import java.util.Arrays;

public class Solution_1785 {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = Arrays.stream(nums).asLongStream().sum();
        return (int) ((Math.abs(sum - goal) + limit - 1) / limit);
    }
}
