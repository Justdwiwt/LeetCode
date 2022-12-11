package main.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_1462 {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean[][] G = new boolean[n][n];
        IntStream.range(0, prerequisites.length).forEach(i -> G[prerequisites[i][0]][prerequisites[i][1]] = true);

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    if (G[j][i] && G[i][k])
                        G[j][k] = true;

        return Arrays.stream(queries)
                .map(query -> G[query[0]][query[1]])
                .collect(Collectors.toList());
    }
}
