package main.java;

import java.util.stream.IntStream;

public class Solution_947 {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        if (n <= 1) return 0;
        int[] parent = IntStream.range(0, n).toArray();
        int sum = 0;
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                if ((stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) && find(parent, i) != find(parent, j)) {
                    union(parent, i, j);
                    sum++;
                }
        return sum;
    }

    private void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    private int find(int[] parent, int index) {
        if (parent[index] != index) parent[index] = find(parent, parent[index]);
        return parent[index];
    }
}
