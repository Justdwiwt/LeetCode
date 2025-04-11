package main.java;

import java.util.stream.IntStream;

public class Solution_2566 {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        int n = s.length();

        char[] max = chars.clone();
        for (int i = 0; i < n; i++)
            if (max[i] != '9') {
                for (int j = i; j < n; j++) if (max[j] == chars[i]) max[j] = '9';
                break;
            }

        char[] min = chars.clone();
        IntStream.range(0, n).filter(i -> min[i] == chars[0]).forEach(i -> min[i] = '0');

        return Integer.parseInt(String.valueOf(max)) - Integer.parseInt(String.valueOf(min));
    }
}
