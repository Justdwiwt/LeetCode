package main.java;

import java.util.Arrays;

public class Solution_1657 {
    public boolean closeStrings(String word1, String word2) {
        int[] sum1 = countLetters(word1);
        int[] sum2 = countLetters(word2);
        for (int i = 0; i < sum1.length; i++)
            if (sum1[i] * sum2[i] == 0 && sum1[i] + sum2[i] > 0)
                return false;
        Arrays.sort(sum1);
        Arrays.sort(sum2);
        return Arrays.equals(sum1, sum2);
    }

    private int[] countLetters(String word) {
        int[] sum = new int[26];
        for (char c : word.toCharArray()) sum[c - 'a']++;
        return sum;
    }
}
