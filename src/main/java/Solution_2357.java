package main.java;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution_2357 {
    public int minimumOperations(int[] nums) {
        return Arrays.stream(nums)
                .filter(num -> num != 0)
                .boxed()
                .collect(Collectors.toSet())
                .size();
    }
}
