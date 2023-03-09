package main.java;

import java.util.Arrays;

public class Solution_1040 {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int n = stones.length;
        int mxStep = (stones[n - 1] - stones[0] + 1 - n) - Math.min(stones[n - 1] - stones[n - 2] - 1, stones[1] - stones[0] - 1);
        int mnStep = mxStep, i = 0, j = 0, step;
        for (; i < n; i++) {
            while (j + 1 < n && stones[j + 1] - stones[i] + 1 <= n)
                ++j;
            step = n - (j - i + 1);
            if (j - i + 1 == n - 1 && stones[j] - stones[i] + 1 == n - 1)
                step = 2;
            mnStep = Math.min(mnStep, step);
        }
        return new int[]{mnStep, mxStep};
    }
}
