package main.java;

import java.util.stream.IntStream;

public class Solution_1745 {
    public boolean checkPartitioning(String s) {
        int n = s.length();
        boolean[][] arr = new boolean[n][n];
        char[] ch = s.toCharArray();
        IntStream.range(0, n).forEach(i -> arr[i][i] = true);
        for (int i = n - 1; i >= 0; i--)
            for (int j = n - 1; j > i; j--)
                arr[i][j] = ch[i] == ch[j] && (j - i < 2 || arr[i + 1][j - 1]);
        return IntStream.range(0, n).anyMatch(i -> IntStream.range(i + 2, n).anyMatch(j -> arr[0][i] && arr[i + 1][j - 1] && arr[j][n - 1]));
    }
}
