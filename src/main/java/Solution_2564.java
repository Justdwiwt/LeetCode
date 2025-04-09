package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution_2564 {
    public int[][] substringXorQueries(String s, int[][] queries) {
        int n = s.length();
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j <= 30 && j + i < n; j++) {
                sum = (sum << 1) | (s.charAt(j + i) - 48);
                int[] p = map.getOrDefault(sum, new int[]{0, n + 5});
                if (j < p[1] - p[0]) map.put(sum, new int[]{i, j + i});
            }
        }
        n = queries.length;
        IntStream.range(0, n).forEach(i -> queries[i] = map.getOrDefault(queries[i][1] ^ queries[i][0], new int[]{-1, -1}));
        return queries;
    }
}
