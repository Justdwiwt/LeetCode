package main.java;

public class Solution_2327 {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int[] exist = new int[n];
        exist[0] = 1;

        for (int i = 1; i < n; i++)
            for (int j = i - delay; j >= i - forget + 1; j--) {
                if (j < 0) break;
                exist[i] += exist[j];
                exist[i] %= 1000000007;
            }

        int res = 0;
        for (int i = n - 1; i >= n - forget; i--) {
            res += exist[i];
            res %= 1000000007;
        }

        return res;
    }
}
