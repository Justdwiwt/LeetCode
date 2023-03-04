package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_1072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int N = matrix[0].length, res = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int[] ints : matrix) {
            String row = IntStream.range(0, N).mapToObj(j -> String.valueOf(ints[0] ^ ints[j])).collect(Collectors.joining());
            map.put(row, map.getOrDefault(row, 0) + 1);
            res = Math.max(res, map.get(row));
        }
        return res;
    }
}
