package main.java;

public class Solution_2573 {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        for (int i = 0; i < n; i++) {
            if (lcp[i][i] != n - i) return "";
            for (int j = i + 1; j < n; j++)
                if (lcp[i][j] != lcp[j][i] || lcp[i][j] > n - Math.max(i, j)) return "";
        }

        char[] ans = new char[n];
        int index = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            while (index < n && ans[index] != 0) index++;
            if (index >= n) break;
            for (int j = index; j < n; j++)
                if (lcp[index][j] > 0) ans[j] = c;
        }

        while (index < n) if (ans[index++] == 0) return "";

        for (int i = n - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--) {
                int now = 0;
                if (ans[i] == ans[j]) {
                    now = 1;
                    if (i + 1 < n && j + 1 < n) now += lcp[i + 1][j + 1];
                }
                if (lcp[i][j] != now) return "";
            }

        return String.valueOf(ans);
    }
}
