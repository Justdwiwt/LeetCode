package main.java;

import java.util.Arrays;
import java.util.HashMap;

public class Solution_2206 {
    public boolean divideArray(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<>();
        Arrays.stream(nums).forEach(num -> m.compute(num, (k, v) -> v == null ? 1 : ++v));
        return m.values()
                .stream()
                .noneMatch(v -> (v & 1) == 1);
    }
}
