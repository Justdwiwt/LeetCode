package main.java;

import java.util.stream.IntStream;

public class Solution_1456 {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int maxLen = 0;
        int[] prefixSum = new int[n + 1];
        IntStream.range(1, n + 1).forEach(i -> prefixSum[i] = prefixSum[i - 1] + (isVowel(s.charAt(i - 1)) ? 1 : 0));
        for (int i = 0; i < n - k + 1; i++) maxLen = Math.max(maxLen, prefixSum[i + k] - prefixSum[i]);
        return maxLen;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
