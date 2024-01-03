package main.java;

import java.util.*;
import java.util.stream.Collectors;

public class Solution_229 {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = Arrays
                .stream(nums)
                .boxed()
                .collect(Collectors.toMap(num -> num, num -> 1, Integer::sum, () -> new HashMap<>(16)));
        int len = nums.length / 3;
        List<Integer> res = new ArrayList<>();
        map.forEach((key, value) -> {
            if (value > len) res.add(key);
        });
        return res;
    }
}
