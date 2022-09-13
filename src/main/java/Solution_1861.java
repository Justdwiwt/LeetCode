package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_1861 {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length, n = box[0].length;
        char[][] res = new char[n][m];
        IntStream.range(0, n).forEach(i -> Arrays.fill(res[i], '.'));
        for (int i = 0; i < m; i++) {
            int idx = n - 1, idy = m - i - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '.') continue;
                if (box[i][j] == '#') res[idx--][idy] = '#';
                else {
                    res[j][idy] = '*';
                    idx = j - 1;
                }
            }
        }
        return res;
    }
}
