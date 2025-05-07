package main.java;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_2593 {
    public long findScore(int[] nums) {
        List<int[]> numIndexPairs = IntStream.range(0, nums.length)
                .mapToObj(i -> new int[]{nums[i], i})
                .sorted(Comparator.comparingInt(pair -> pair[0]))
                .collect(Collectors.toList());

        Set<Integer> marked = new HashSet<>();
        long res = 0L;
        for (int[] pair : numIndexPairs) {
            int num = pair[0];
            int index = pair[1];
            if (!marked.contains(index)) {
                marked.add(index);
                marked.add(index - 1);
                marked.add(index + 1);
                res += num;
            }
        }
        return res;
    }
}
