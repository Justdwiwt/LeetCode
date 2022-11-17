package main.java;

import java.util.stream.IntStream;

public class Solution_1573 {
    public int numWays(String s) {
        int num = (int) IntStream.range(0, s.length()).filter(i -> s.charAt(i) == '1').count();
        if (num % 3 != 0) return 0;
        long M = 1000000007;
        if (num == 0) return (int) (((long) (s.length() - 1) * (s.length() - 2) / 2) % M);
        num /= 3;
        long count = 0, d1 = 0, d2 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count++;
            if (count == num) ++d1;
            if (count == 2 * num) ++d2;
        }
        return (int) (((d1) * (d2)) % M);
    }
}
