package main.java;

import java.util.Arrays;

public class Solution_2952 {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int count = 0;
        int currentMax = 0;
        for (int coin : coins) {
            while (coin > currentMax + 1) {
                count++;
                currentMax += currentMax + 1;
            }
            currentMax += coin;
            if (currentMax >= target) return count;
        }
        while (currentMax < target) {
            count++;
            currentMax += currentMax + 1;
        }
        return count;
    }
}
