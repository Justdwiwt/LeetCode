package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_2761 {
    private static int primeLen = 0;
    private static final int N = 1000001;
    private static final boolean[] PRIMES = new boolean[N];
    private static final int[] NP = new int[78498];

    static {
        boolean[] isVisited = new boolean[N];
        for (int i = 2; i < N; i++) {
            if (isVisited[i]) continue;
            PRIMES[i] = true;
            NP[primeLen++] = i;
            if (i > 1000) continue;
            for (int j = i * i; j < N; j += i)
                isVisited[j] = true;
        }
    }

    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        if ((n & 1) == 1) {
            if (n > 1 && PRIMES[n - NP[0]]) ans.add(List.of(2, n - 2));
            return ans;
        }
        int half = n >> 1;
        for (int i = 0; i < primeLen && NP[i] <= half; i++)
            if (PRIMES[n - NP[i]]) ans.add(List.of(NP[i], n - NP[i]));
        return ans;
    }
}
