package main.java;

import java.util.Arrays;

public class Solution_2943 {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        return (int) Math.pow(Math.min(find(hBars), find(vBars)), 2);
    }

    int find(int a[]) {
        int ans = 2, count = 2;
        Arrays.sort(a);
        for (int i = 1; i < a.length; i++) {
            count = a[i] == a[i - 1] + 1 ? count + 1 : 2;
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
