package main.java;

public class Solution_1155 {
    static final int M = (int) 1e9 + 7;

    public int numRollsToTarget(int n, int k, int target) {
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 0; i < n; ++i)
            for (int t = target; t >= 0; --t) {
                f[t] = 0;
                for (int s = 1; s <= k; ++s)
                    if (t >= s) f[t] = (f[t] + f[t - s]) % M;
            }
        return f[target];
    }
}
