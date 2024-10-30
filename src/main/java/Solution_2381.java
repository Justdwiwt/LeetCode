package main.java;

import java.util.Arrays;

public class Solution_2381 {
    public String shiftingLetters(String ss, int[][] shifts) {
        char[] c = ss.toCharArray();
        int n = c.length;
        int[] d = new int[n + 1];
        Arrays.stream(shifts).forEach(x -> {
            int from = x[0], to = x[1], direction = x[2];
            d[from] = direction == 1 ? d[from] + 1 : d[from] - 1;
            d[to + 1] = direction == 1 ? d[to + 1] - 1 : d[to + 1] + 1;
        });
        int s = 0;
        for (int i = 0; i < n; i++) {
            s += d[i];
            c[i] = (char) ((c[i] - 'a' + 26 + s % 26) % 26 + 'a');
        }
        return String.valueOf(c);
    }
}
