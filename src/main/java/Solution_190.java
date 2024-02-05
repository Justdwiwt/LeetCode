package main.java;

public class Solution_190 {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++)
            res = (res << 1) + ((n & (1 << i)) == 0 ? 0 : 1);
        return res;
    }
}
