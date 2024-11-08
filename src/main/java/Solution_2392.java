package main.java;

import java.util.*;
import java.util.stream.IntStream;

public class Solution_2392 {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] row = buildMatrix(k, rowConditions);
        int[] col = buildMatrix(k, colConditions);
        int[][] mat = new int[k][k];
        for (int i = 0; i < row.length; i++) {
            if (row[i] == -1 || col[i] == -1) return new int[0][0];
            mat[row[i]][col[i]] = i + 1;
        }
        return mat;
    }

    private int[] buildMatrix(int k, int[][] rowConditions) {
        List<Integer>[] grid = new List[k];
        Arrays.setAll(grid, e -> new ArrayList<>());
        int[] deg = new int[k];
        Arrays.stream(rowConditions).forEach(rowCondition -> {
            int a = rowCondition[0] - 1, b = rowCondition[1] - 1;
            grid[a].add(b);
            deg[b]++;
        });
        Deque<Integer> deque = new ArrayDeque<>();
        IntStream.range(0, k).filter(i -> deg[i] == 0).forEach(deque::offer);
        int[] row = new int[k];
        Arrays.fill(row, -1);
        int i = 0;
        while (!deque.isEmpty()) {
            int x = deque.poll();
            row[x] = i++;
            grid[x].stream().mapToInt(y -> y).filter(y -> --deg[y] == 0).forEach(deque::offer);
        }
        return row;
    }
}
