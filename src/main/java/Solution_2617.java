package main.java;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_2617 {
    public int minimumVisitedCells(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 1});
        int m = grid.length, n = grid[0].length;
        boolean[][] isVisited = new boolean[m][n];
        TreeSet<Integer>[] rowSet = IntStream.range(0, m).mapToObj(i -> IntStream.range(1, n).boxed().collect(Collectors.toCollection(TreeSet::new))).toArray(TreeSet[]::new);
        TreeSet<Integer>[] colSet = IntStream.range(0, n).mapToObj(i -> IntStream.range(1, m).boxed().collect(Collectors.toCollection(TreeSet::new))).toArray(TreeSet[]::new);
        while (!queue.isEmpty()) {
            int[] array = queue.poll();
            int curRow = array[0], curCol = array[1], depth = array[2];
            if (curRow == m - 1 && curCol == n - 1) return depth;
            int minCol = rowSet[curRow].ceiling(curCol) == null ? Integer.MAX_VALUE : rowSet[curRow].ceiling(curCol), maxCol = Math.min(n - 1, curCol + grid[curRow][curCol]);
            IntStream.rangeClosed(minCol, maxCol).filter(newCol -> !isVisited[curRow][newCol]).forEach(newCol -> {
                isVisited[curRow][newCol] = true;
                rowSet[curRow].remove(newCol);
                queue.add(new int[]{curRow, newCol, depth + 1});
            });
            int minRow = colSet[curCol].ceiling(curRow) == null ? Integer.MAX_VALUE : colSet[curCol].ceiling(curRow), maxRow = Math.min(m - 1, curRow + grid[curRow][curCol]);
            IntStream.rangeClosed(minRow, maxRow).filter(newRow -> !isVisited[newRow][curCol]).forEach(newRow -> {
                isVisited[newRow][curCol] = true;
                colSet[curCol].remove(newRow);
                queue.add(new int[]{newRow, curCol, depth + 1});
            });

        }
        return -1;
    }
}
