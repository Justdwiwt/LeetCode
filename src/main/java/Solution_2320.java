package main.java;

public class Solution_2320 {
    int M = (int) 1e9 + 7;

    public int countHousePlacements(int n) {
        long[] res = {1, 1, 1, 1};
        for (int i = 2; i <= n; i++)
            res = new long[]{(res[0] + res[1] + res[2] + res[3]) % M, (res[0] + res[2]) % M, (res[0] + res[1]) % M, res[0]};
        return (int) ((res[0] + res[1] + res[2] + res[3]) % M);
    }
}
