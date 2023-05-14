package main.java;

import java.util.stream.IntStream;

public class Solution_838 {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] ch = dominoes.toCharArray();
        for (int i = 0; i < n; i++)
            if (ch[i] == '.') {
                int end = i;
                while (end + 1 < n && ch[end + 1] == '.') end++;
                char left = i - 1 > -1 ? ch[i - 1] : 'L';
                char right = end + 1 < n ? ch[end + 1] : 'R';
                if (left == right) IntStream.rangeClosed(i, end).forEach(j -> ch[j] = left);
                else if (left == 'R' && right == 'L') {
                    int cnt = (end - i + 1) / 2;
                    for (int j = 0; j < cnt; j++) {
                        ch[i + j] = 'R';
                        ch[end - j] = 'L';
                    }
                }
                i = end;
            }
        return new String(ch);
    }
}
