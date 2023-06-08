package main.java;

import java.util.Arrays;

public class Solution_753 {
    public String crackSafe(int n, int k) {
        int kn = (int) Math.pow(k, n), kn_1 = (int) Math.pow(k, n - 1);
        int[] num = new int[kn_1];
        Arrays.fill(num, k - 1);
        char[] c = new char[kn + n - 1];
        Arrays.fill(c, '0');
        for (int i = n - 1, node = 0; i < c.length; ++i) {
            c[i] = (char) ('0' + num[node]--);
            node = node * k - (c[i - (n - 1)] - '0') * kn_1 + num[node] + 1;
        }
        return new String(c);
    }
}
