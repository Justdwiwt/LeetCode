package main.java;

import java.util.Arrays;

public class Solution_809 {
    public int expressiveWords(String s, String[] words) {
        char[] ch = s.toCharArray();
        return Arrays.stream(words).mapToInt(str -> judge(ch, str.toCharArray()) ? 1 : 0).sum();
    }

    private boolean judge(char[] ch, char[] str) {
        int p1 = 0, p2 = 0;
        int low;
        while ((low = p1) < ch.length && p2 < str.length) {
            int c1 = 0, c2 = 0;
            while (p1 < ch.length && ch[p1] == ch[low]) {
                p1++;
                c1++;
            }
            while (p2 < str.length && str[p2] == ch[low]) {
                p2++;
                c2++;
            }
            if (c1 != c2 && c1 < 3 || c1 < c2) return false;
        }
        return p1 == ch.length && p2 == str.length;
    }
}
