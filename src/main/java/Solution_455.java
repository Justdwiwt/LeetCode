package main.java;

import java.util.Arrays;

public class Solution_455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = g.length, m = s.length, ans = 0;
        for (int i = 0, j = 0; i < n && j < m; i++) {
            while (j < m && s[j] < g[i]) j++;
            if (j++ < m) ans++;
        }
        return ans;
    }
}
