package main.java;

import java.util.Arrays;

public class Solution_899 {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String res = s;
            int n = s.length();
            for (int i = 0; i < n - 1; i++) {
                s = s.substring(1) + s.charAt(0);
                if (s.compareTo(res) < 0) res = s;
            }
            return res;
        } else {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            return new String(chs);
        }
    }
}
