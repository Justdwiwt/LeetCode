package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_1498 {
    public int numSubseq(int[] A, int sum) {
        Arrays.sort(A);
        int res = 0, mod = (int) 1e9 + 7, len = A.length, r = len - 1;
        int[] dic = new int[len];
        dic[0] = 1;
        IntStream.range(1, len).forEach(i -> dic[i] = (dic[i - 1] << 1) % mod);
        for (int l = 0; l <= r; l++) {
            while (A[r] + A[l] > sum && r > l) r--;
            if (A[r] + A[l] <= sum) {
                res += dic[r - l];
                res %= mod;
            }
        }
        return res;
    }
}
