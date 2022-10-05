package main.java;

import java.util.Arrays;
import java.util.HashMap;

public class Solution_1748 {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<>();
        Arrays.stream(nums).forEach(num -> m.put(num, m.getOrDefault(num, 0) + 1));
        return m.keySet().stream().mapToInt(key -> key).filter(key -> m.get(key) == 1).sum();
    }
}
