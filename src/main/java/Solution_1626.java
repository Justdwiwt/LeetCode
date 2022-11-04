package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_1626 {
    public int bestTeamScore(int[] scores, int[] ages) {
        int[][] arr = new int[scores.length][2];
        IntStream.range(0, scores.length).forEach(i -> {
            arr[i][0] = scores[i];
            arr[i][1] = ages[i];
        });
        Arrays.sort(arr, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int[] dp = new int[scores.length];
        dp[0] = arr[0][0];
        int res = dp[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = arr[i][0];
            for (int j = 0; j < i; j++)
                if (arr[i][1] == arr[j][1] || arr[i][0] >= arr[j][0])
                    dp[i] = Math.max(dp[i], dp[j] + arr[i][0]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
