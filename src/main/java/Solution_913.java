package main.java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Solution_913 {
    public int catMouseGame(int[][] graph) {
        int N = graph.length;
        int[][][] dp = new int[N][N][2];
        Queue<int[]> q = new LinkedList<>();
        IntStream.range(1, N).forEach(i -> {
            dp[0][i][0] = dp[0][i][1] = 1;
            dp[i][i][0] = dp[i][i][1] = 2;
            q.add(new int[]{0, i, 0});
            q.add(new int[]{0, i, 1});
            q.add(new int[]{i, i, 0});
            q.add(new int[]{i, i, 1});
        });
        int[][][] deg = new int[N][N][2];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                deg[i][j][0] = graph[i].length;
                deg[i][j][1] = graph[j].length;
            }
        Arrays.stream(graph[0]).forEach(j -> IntStream.range(0, N).forEach(i -> deg[i][j][1]--));
        while (q.size() > 0) {
            int[] t = q.poll();
            int x = t[0];
            int y = t[1];
            int c = t[2];
            if (x == 1 && y == 2 && c == 0) break;
            if (c == 0)
                Arrays.stream(graph[y]).filter(j -> j != 0).filter(j -> dp[x][j][1] == 0).forEach(j -> {
                    if (dp[x][y][c] == 2) {
                        dp[x][j][1] = 2;
                        q.add(new int[]{x, j, 1});
                    } else {
                        deg[x][j][1]--;
                        if (deg[x][j][1] == 0) {
                            dp[x][j][1] = 1;
                            q.add(new int[]{x, j, 1});
                        }
                    }
                });
            else Arrays.stream(graph[x]).filter(i -> dp[i][y][0] == 0).forEach(i -> {
                if (dp[x][y][c] == 1) {
                    dp[i][y][0] = 1;
                    q.add(new int[]{i, y, 0});
                } else {
                    deg[i][y][0]--;
                    if (deg[i][y][0] == 0) {
                        dp[i][y][0] = 2;
                        q.add(new int[]{i, y, 0});
                    }
                }
            });
        }
        return dp[1][2][0];
    }
}
