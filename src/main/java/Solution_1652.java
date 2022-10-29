package main.java;

public class Solution_1652 {
    public int[] decrypt(int[] code, int k) {
        int len = code.length;
        int[] res = new int[len];
        int e = k >= 0 ? k == 0 ? 0 : 1 : -1;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = e; j != k + e; j += e)
                sum += code[(i + j + len) % len];
            res[i] = sum;
        }
        return res;
    }
}
