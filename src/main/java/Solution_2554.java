package main.java;

import java.util.Arrays;

public class Solution_2554 {
    public int maxCount(int[] banned, int n, int maxSum) {
        int[] set = new int[10010];
        Arrays.stream(banned).forEach(num -> set[num] = 1);
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (i > maxSum) break;
            if (set[i] == 0) {
                maxSum -= i;
                ans++;
            }
        }
        return ans;
    }
}
