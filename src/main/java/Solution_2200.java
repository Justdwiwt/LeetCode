package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_2200 {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set;
        set = IntStream.range(0, nums.length).filter(i -> nums[i] == key).boxed().collect(Collectors.toSet());
        for (int j : set)
            for (int i = 0; i < nums.length; i++)
                if (Math.abs(i - j) <= k) res.add(i);
        res = res.stream().distinct().collect(Collectors.toList());
        Collections.sort(res);
        return res;
    }
}
