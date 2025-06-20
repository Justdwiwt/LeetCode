package main.java;

import java.util.stream.IntStream;

public class Solution_2672 {
    public int[] colorTheArray(int n, int[][] queries) {
        int m = queries.length;
        int[] ans = new int[m];
        int[] color = new int[n];
        color[queries[0][0]] = queries[0][1];
        IntStream.range(1, m).forEach(i -> {
            ans[i] = ans[i - 1];
            if (queries[i][0] > 0 && color[queries[i][0]] > 0 && color[queries[i][0]] == color[queries[i][0] - 1])
                ans[i]--;
            if (queries[i][0] < n - 1 && color[queries[i][0]] > 0 && color[queries[i][0]] == color[queries[i][0] + 1])
                ans[i]--;
            color[queries[i][0]] = queries[i][1];
            if (queries[i][0] > 0 && color[queries[i][0]] == color[queries[i][0] - 1])
                ans[i]++;
            if (queries[i][0] < n - 1 && color[queries[i][0]] == color[queries[i][0] + 1])
                ans[i]++;
        });
        return ans;
    }
}
