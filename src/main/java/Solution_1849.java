package main.java;

public class Solution_1849 {
    public boolean splitString(String s) {
        return dfs(s.toCharArray(), 0, 0);
    }

    private boolean dfs(char[] str, int s, long pre) {
        if (s == str.length) return true;
        long val = 0;
        int len = s == 0 ? str.length - 1 : str.length;
        for (int i = s; i < len; i++) {
            val = val * 10 + str[i] - '0';
            if (s != 0 && val >= pre) break;
            if (s == 0 || val == pre - 1)
                if (dfs(str, i + 1, val)) return true;
        }
        return false;
    }
}
