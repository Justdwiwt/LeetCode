package main.java;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_1632 {
    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n];
        int[] row = new int[m];
        int[] col = new int[n];
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                pq.offer(new int[]{matrix[i][j], i, j});
        while (!pq.isEmpty()) {
            int target = pq.peek()[0];
            List<int[]> list = new ArrayList<>();
            while (!pq.isEmpty() && pq.peek()[0] == target)
                list.add(pq.poll());
            UF uf = new UF(m + n);
            list.forEach(pair -> uf.union(pair[1], pair[2] + m));
            Map<Integer, List<int[]>> map = list.stream().collect(Collectors.groupingBy(pair -> uf.find(pair[1])));
            for (List<int[]> group : map.values()) {
                int rank = 0;
                for (int[] arr : group) {
                    int i = arr[1], j = arr[2];
                    rank = Math.max(rank, Math.max(row[i], col[j]) + 1);
                }
                for (int[] arr : group) {
                    int i = arr[1], j = arr[2];
                    res[i][j] = rank;
                    row[i] = Math.max(row[i], rank);
                    col[j] = Math.max(col[j], rank);
                }
            }
        }
        return res;
    }

    static class UF {
        UF(int size) {
            parent = new int[size];
            IntStream.range(0, size).forEach(i -> parent[i] = i);
        }

        private final int[] parent;

        private int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        private void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }
}
