package main.java;

import java.util.Arrays;

public class Solution_1402 {
    public int maxSatisfaction(int[] s) {
        Arrays.sort(s);
        int sum = 0, val = 0;
        for (int i = s.length - 1; i >= 0; i--) {
            sum += s[i];
            if (sum <= 0) break;
            val += sum;
        }
        return val;
    }
}
