package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_2961 {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0, n = variables.length; i < n; i++) {
            int a = variables[i][0], b = variables[i][1], c = variables[i][2], m = variables[i][3];
            if (func(func(a, b, 10), c, m) == target) ans.add(i);
        }
        return ans;
    }

    public int func(int a, int b, int x) {
        if (b < 2) return b == 0 ? 1 % x : a % x;
        int d = b >> 1, f = b & 1;
        int aa = (a * a) % x;
        return (func(aa, d, x) * func(a, f, x)) % x;
    }
}
