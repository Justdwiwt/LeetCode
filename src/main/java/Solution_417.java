package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_417 {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return res;

        boolean[][] reach_pac = new boolean[matrix.length][matrix[0].length];
        boolean[][] reach_atl = new boolean[matrix.length][matrix[0].length];
        IntStream.range(0, matrix.length).forEach(i -> {
            dfs(matrix, i, 0, reach_pac);
            dfs(matrix, i, matrix[0].length - 1, reach_atl);
        });

        IntStream.range(0, matrix[0].length).forEach(j -> {
            dfs(matrix, 0, j, reach_pac);
            dfs(matrix, matrix.length - 1, j, reach_atl);
        });

        for (int i = 0; i < matrix.length; ++i)
            for (int j = 0; j < matrix[0].length; ++j)
                if (reach_pac[i][j] && reach_atl[i][j])
                    res.add(new ArrayList<>(Arrays.asList(i, j)));

        return res;
    }


    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    void dfs(int[][] M, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        Arrays.stream(dir).forEach(d -> {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && x < M.length && y >= 0 && y < M[0].length && !visited[x][y] && M[x][y] >= M[i][j])
                dfs(M, x, y, visited);
        });
    }
}
