package main.java;

import java.util.Arrays;

public class Solution_828 {
    public int uniqueLetterString(String s) {
        int[] pos = new int[26];
        int[] len = new int[26];
        Arrays.fill(pos, -1);
        char[] chars = s.toCharArray();
        int n = chars.length;
        long res = 0, base = 0;
        for (int i = 0; i < n; i++) {
            int c = chars[i] - 'A';
            int past = i - pos[c];
            base += past - len[c];
            res += base;
            len[c] = past;
            pos[c] = i;
        }
        return (int) (res % 1000000007);
    }
}
