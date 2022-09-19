package main.java;

import java.util.Arrays;

public class Solution_1833 {
    public int maxIceCream(int[] cs, int t) {
        Arrays.sort(cs);
        int res = 0;
        for (int c : cs)
            if (t >= c) {
                res++;
                t -= c;
            }
        return res;
    }
}
