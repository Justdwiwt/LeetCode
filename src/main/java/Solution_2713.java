package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Solution_2713 {
    public int maxIncreasingCells(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        TreeMap<Integer, List<int[]>> numToPosListMap = new TreeMap<>();
        for (int row = 0; row < m; row++)
            for (int col = 0; col < n; col++)
                numToPosListMap.computeIfAbsent(mat[row][col], key -> new ArrayList<>()).add(new int[]{row, col});

        int[] rowMax = new int[m], colMax = new int[n];
        for (List<int[]> posList : numToPosListMap.values()) {
            List<Integer> resultList = new ArrayList<>(posList.size());
            posList.forEach(ints -> {
                int row = ints[0], col = ints[1];
                resultList.add(Math.max(rowMax[row], colMax[col]) + 1);
            });
            IntStream.range(0, posList.size()).forEach(index -> {
                int row = posList.get(index)[0], col = posList.get(index)[1];
                rowMax[row] = Math.max(rowMax[row], resultList.get(index));
                colMax[col] = Math.max(colMax[col], resultList.get(index));
            });
        }
        return Arrays.stream(rowMax).max().getAsInt();
    }
}
