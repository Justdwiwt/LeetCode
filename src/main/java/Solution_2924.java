package main.java;

import java.util.Arrays;

public class Solution_2924 {
    public int findChampion(int n, int[][] edges) {
        boolean[] vic = new boolean[n];
        Arrays.stream(edges).forEach(e -> vic[e[1]] = true);
        int flag = -1;
        for (int i = 0; i < n; i++)
            if (!vic[i]) {
                if (flag != -1) return -1;
                flag = i;
            }
        return flag;
    }
}
