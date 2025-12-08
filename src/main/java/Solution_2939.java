package main.java;

public class Solution_2939 {
    final long MOD = (long) 1e9 + 7;

    public int maximumXorProduct(long a, long b, int n) {
        long aa = 0, bb = 0;
        for (int i = 62; i >= n; --i) {
            if ((a >> i & 1) == 1) aa |= 1L << i;
            if ((b >> i & 1) == 1) bb |= 1L << i;
        }
        for (int i = n - 1; i >= 0; --i) {
            boolean x = (a >> i & 1) == 1, y = (b >> i & 1) == 1;
            if (x == y) {
                aa |= 1L << i;
                bb |= 1L << i;
            } else {
                if (aa <= bb) aa |= 1L << i;
                else bb |= 1L << i;
            }
        }
        return (int) (((aa % MOD) * (bb % MOD)) % MOD);
    }
}
