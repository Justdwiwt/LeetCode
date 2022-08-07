package main.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_2033 {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list = Arrays.stream(grid)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .sorted()
                .collect(Collectors.toList());
        int size = list.size();
        int median = list.get(size / 2);
        int operations = 0;
        for (Integer num : list) {
            int diff = Math.abs(num - median);
            if (diff % x != 0) return -1;
            operations += diff / x;
        }
        return operations;
    }
}
