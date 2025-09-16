package main.java;

public class Solution_2825 {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        if (n < m) return false;
        char[] chars1 = str1.toCharArray(), chars2 = str2.toCharArray();
        for (int i = 0, j = 0; i < n; i++) {
            int c1 = chars1[i] - 'a', c2 = (c1 + 1) % 26, c3 = chars2[j] - 'a';
            if (c1 == c3 || c2 == c3) if (++j >= m) return true;
        }
        return false;
    }
}
