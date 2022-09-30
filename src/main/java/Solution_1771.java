package main.java;

import java.util.stream.IntStream;

public class Solution_1771 {
    public int longestPalindrome(String word1, String word2) {
        int res = 0, border = word1.length();
        char[] ch = (word1 + word2).toCharArray();
        int[][] arr = new int[ch.length][ch.length];
        IntStream.range(0, ch.length).forEach(i -> arr[i][i] = 1);
        for (int d = 1; d < ch.length; d++)
            for (int i = 0; i < ch.length - d; i++) {
                arr[i][i + d] = Math.max(arr[i][i + d - 1], arr[i + 1][i + d]);
                if (ch[i] == ch[i + d]) {
                    if (i < border && i + d >= border)
                        res = Math.max(res, arr[i + 1][i + d - 1] + 2);
                    arr[i][i + d] = Math.max(arr[i][i + d], arr[i + 1][i + d - 1] + 2);
                }
            }
        return res;
    }
}
