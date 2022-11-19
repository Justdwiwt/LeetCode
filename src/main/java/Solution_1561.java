package main.java;

import java.util.Arrays;

public class Solution_1561 {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int res = 0;
        for (int i = piles.length / 3; i < piles.length; i += 2)
            res += piles[i];
        return res;
    }
}
