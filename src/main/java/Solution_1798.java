package main.java;

import java.util.Arrays;

public class Solution_1798 {
    public int getMaximumConsecutive(int[] coins) {
        int now = 0;
        Arrays.sort(coins);
        for (int coin : coins)
            if (coin <= now + 1) {
                now += coin;
            } else break;
        return now + 1;
    }
}
