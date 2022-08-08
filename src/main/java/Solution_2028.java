package main.java;

import java.util.Arrays;

public class Solution_2028 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = Arrays.stream(rolls).sum();
        int sumOfMissing = mean * (rolls.length + n) - sum;
        if (sumOfMissing < n || sumOfMissing > n * 6) return new int[]{};
        int[] res = new int[n];
        for (int i = 0; sumOfMissing > 0; sumOfMissing -= res[i++])
            res[i] = sumOfMissing / (n - i);
        return res;
    }
}
