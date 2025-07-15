package main.java;

public class Solution_2718 {
    public long matrixSumQueries(int n, int[][] queries) {
        int[] counts = new int[]{n, n};
        boolean[][] visited = new boolean[2][n];
        long result = 0;
        for (int i = queries.length - 1; i >= 0; i--) {
            int type = queries[i][0], index = queries[i][1], val = queries[i][2];
            if (!visited[type][index]) {
                counts[1 - type]--;
                visited[type][index] = true;
                result += (long) counts[type] * val;
            }
        }
        return result;
    }
}
