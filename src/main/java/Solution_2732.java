package main.java;

import java.util.*;

public class Solution_2732 {
    public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        int m = grid.length;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int num = 0;
            for (int j : grid[i]) num = num << 1 | j;
            if (num == 0) return Collections.singletonList(i);
            if (!map.containsKey(num)) {
                map.put(num, i);
                list.add(num);
            }
        }
        int n = list.size();
        for (int i = 0; i < n; i++) {
            int x = list.get(i);
            for (int j = i + 1; j < n; j++) {
                int y = list.get(j);
                if ((x & y) == 0) return Arrays.asList(map.get(x), map.get(y));
            }
        }
        return Collections.emptyList();
    }
}
