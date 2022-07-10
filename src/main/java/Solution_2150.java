package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution_2150 {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> res;
        Map<Integer, Integer> m = new HashMap<>();
        Arrays.stream(nums).forEach(e -> m.put(e, m.getOrDefault(e, 0) + 1));
        res = m.keySet().stream()
                .mapToInt(key -> key)
                .filter(key -> m.get(key) == 1 && !m.containsKey(key + 1) && !m.containsKey(key - 1))
                .boxed()
                .collect(Collectors.toList());
        return res;
    }
}
