package main.java;

import java.util.stream.IntStream;

public class Solution_547 {
    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int res = 0;
        for (int i = 0; i < M.length; ++i)
            if (!visited[i]) {
                dfs(M, visited, i);
                res++;
            }
        return res;
    }

    private void dfs(int[][] m, boolean[] visited, int i) {
        IntStream.range(0, m.length).filter(j -> m[i][j] == 1 && !visited[j]).forEach(j -> {
            visited[j] = true;
            dfs(m, visited, j);
        });
    }
}
