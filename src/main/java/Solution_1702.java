package main.java;

import java.util.Arrays;

public class Solution_1702 {
    public String maximumBinaryString(String binary) {
        int len = binary.length();
        char[] res = new char[len];
        Arrays.fill(res, '1');
        int zeros = 0;
        for (char c : binary.toCharArray())
            if (c == '0')
                zeros++;
        int idx = binary.indexOf('0');
        if (zeros > 0)
            res[idx + zeros - 1] = '0';
        return new String(res);
    }
}
