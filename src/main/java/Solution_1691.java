package main.java;

import java.util.Arrays;

public class Solution_1691 {
    public int maxHeight(int[][] cuboids) {
        Arrays.stream(cuboids).forEach(Arrays::sort);
        Arrays.sort(cuboids, (o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            else if (o1[1] != o2[1]) return o1[1] - o2[1];
            else return o1[2] - o2[2];
        });
        int[] dp = new int[cuboids.length];
        int res = 0;
        for (int i = 0; i < cuboids.length; i++) {
            dp[i] = cuboids[i][2];
            for (int j = 0; j < i; j++)
                if (cuboids[i][0] >= cuboids[j][0] && cuboids[i][1] >= cuboids[j][1] && cuboids[i][2] >= cuboids[j][2])
                    dp[i] = Math.max(dp[i], cuboids[i][2] + dp[j]);
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
