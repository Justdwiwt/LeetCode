package main.java;

import java.util.Arrays;

public class Solution_2274 {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int res = Math.max(special[0] - bottom, top - special[special.length - 1]);
        for (int i = 1; i < special.length; i++) {
            res = Math.max(res, special[i] - special[i - 1] - 1);
        }
        return res;
    }
}
