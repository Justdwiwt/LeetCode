package main.java;

public class Solution_829 {
    public int consecutiveNumbersSum(int n) {
        int res = 0;
        for (int i = 1; (2 * n) > (i * i - i); i++)
            if (((2 * n) - i * i + i) % (2 * i) == 0) res++;
        return res;
    }
}
