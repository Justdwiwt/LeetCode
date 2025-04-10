package main.java;

import java.util.Arrays;

public class Solution_2565 {
    public int minimumScore(String s, String t) {
        int m = s.length(), n = t.length(), left[] = new int[m], right[] = new int[m];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        for (int i = 0, j = 0; i < m; i++)
            if (j < n && s.charAt(i) == t.charAt(j)) {
                left[i] = j;
                j++;
            } else left[i] = left[Math.max(0, i - 1)];
        for (int i = m - 1, j = n - 1; i >= 0; i--)
            if (j >= 0 && s.charAt(i) == t.charAt(j)) {
                right[i] = j;
                j--;
            } else right[i] = right[Math.min(i + 1, m - 1)];
        int ans = Math.min(n - 1 - left[m - 1], right[0]);
        for (int i = 1; i < m; i++) ans = Math.min(ans, right[i] - left[i - 1] - 1);
        return Math.max(0, ans);
    }
}
