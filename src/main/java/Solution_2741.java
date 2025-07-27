package main.java;

import java.util.stream.IntStream;

public class Solution_2741 {
    static final int MOD = 1000000007;

    public int specialPerm(int[] nums) {
        int n = nums.length;
        int[][] f = new int[1 << n][n];
        IntStream.range(0, n).forEach(i -> f[1 << i][i] = 1);
        for (int state = 1; state < (1 << n); state++)
            for (int i = 0; i < n; i++) {
                if ((state >> i & 1) == 0) continue;
                for (int j = 0; j < n; j++) {
                    if (i == j || (state >> j & 1) == 0) continue;
                    if (nums[i] % nums[j] != 0 && nums[j] % nums[i] != 0) continue;
                    f[state][i] = (f[state][i] + f[state ^ (1 << i)][j]) % MOD;
                }
            }
        int res = 0;
        for (int i = 0; i < n; i++) res = (res + f[(1 << n) - 1][i]) % MOD;
        return res;
    }
}
