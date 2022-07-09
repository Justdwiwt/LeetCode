package main.java;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution_2154 {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        while (set.contains(original)) original *= 2;
        return original;
    }
}
