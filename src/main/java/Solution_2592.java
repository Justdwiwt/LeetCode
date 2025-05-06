package main.java;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution_2592 {
    public int maximizeGreatness(int[] nums) {
        return nums.length - Arrays
                .stream(nums)
                .boxed()
                .collect(Collectors.toMap(Integer::intValue, num -> 1, Integer::sum))
                .values()
                .stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
    }
}
