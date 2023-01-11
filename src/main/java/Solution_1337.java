package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution_1337 {
    public int[] kWeakestRows(int[][] mat, int k) {

        Map<Integer, Integer> integerIntegerMap = new HashMap<>(mat.length / 3 * 4 + 1);
        IntStream.range(0, mat.length).forEach(i -> {
            int sum = Arrays.stream(mat[i]).sum();
            integerIntegerMap.put(i, sum);
        });

        return integerIntegerMap
                .entrySet()
                .stream()
                .sorted(Comparator.<Map.Entry<Integer, Integer>>comparingInt(Map.Entry::getValue).thenComparing(Map.Entry::getKey))
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}
