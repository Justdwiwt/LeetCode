package main.java;

import java.util.Arrays;

public class Solution_1655 {
    public boolean canDistribute(int[] nums, int[] quantity) {
        int[] count = new int[1001];
        Arrays.stream(nums).forEach(a -> count[a]++);
        Arrays.sort(count);
        Arrays.sort(quantity);
        return canMatch(count, quantity, quantity.length - 1);
    }

    private boolean canMatch(int[] count, int[] quantity, int j) {
        if (j == -1) return true;
        for (int i = 1000; i > 950; i--)
            if (count[i] >= quantity[j]) {
                count[i] -= quantity[j];
                if (canMatch(count, quantity, j - 1)) return true;
                count[i] += quantity[j];
            } else if (i == 951) return false;
        return true;
    }
}
