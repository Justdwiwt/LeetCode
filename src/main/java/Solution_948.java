package main.java;

import java.util.Arrays;

public class Solution_948 {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int res = 0;
        int i = 0, j = tokens.length;
        while (i < j)
            if (power >= tokens[i]) {
                res++;
                power -= tokens[i++];
            } else {
                if (res > 0 && j - i > 1) {
                    power += tokens[j - 1];
                    res--;
                }
                j--;
            }
        return res;
    }
}
