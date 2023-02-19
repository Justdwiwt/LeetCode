package main.java;

public class Solution_1147 {
    public int longestDecomposition(String text) {
        int n = text.length();
        if (n == 0) return 0;
        for (int len = 1; len <= n / 2; len++)
            if (text.substring(0, len).equals(text.substring(n - len, n)))
                return 2 + longestDecomposition(text.substring(len, n - len));
        return 1;
    }
}
