package main.java;

public class Solution_868 {
    public int binaryGap(int n) {
        int res = 0;
        for (int i = 0, begin = 32; i < 32; i++)
            if (((n >> i) & 1) == 1) {
                res = Math.max(i - begin, res);
                begin = i;
            }
        return res;
    }
}
