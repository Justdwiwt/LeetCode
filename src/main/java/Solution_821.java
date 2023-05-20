package main.java;

import java.util.Arrays;

public class Solution_821 {
    public int[] shortestToChar(String s, char c) {
        char[] ch = s.toCharArray();
        int[] res = new int[ch.length];
        Arrays.fill(res, ch.length + 5);
        for (int i = ch.length - 1; i >= 0; i--) {
            int j = i;
            while (j >= 0 && ch[j] != c) j--;
            if (j >= 0) res[i] = i - j;
            j = i;
            while (j < ch.length && ch[j] != c) j++;
            if (j < ch.length) res[i] = Math.min(res[i], j - i);
        }
        return res;
    }
}
