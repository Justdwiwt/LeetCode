package main.java;

import java.util.Arrays;

public class Solution_1615 {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] isConnected = new boolean[n][n];
        int[] deg = new int[n];
        int maxDeg = 0;
        Arrays.stream(roads).forEach(edge -> {
            isConnected[edge[0]][edge[1]] = isConnected[edge[1]][edge[0]] = true;
            deg[edge[0]]++;
            deg[edge[1]]++;
        });
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                maxDeg = Math.max(maxDeg, deg[i] + deg[j] - (isConnected[i][j] ? 1 : 0));
        return maxDeg;
    }
}
