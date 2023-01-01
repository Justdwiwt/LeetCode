package main.java;

import java.util.Arrays;

public class Solution_1374 {
    public String generateTheString(int n) {
        char[] res = new char[n];
        Arrays.fill(res, 'a');
        res[0] = (n & 1) == 0 ? 'b' : 'a';
        return new String(res);
    }
}
