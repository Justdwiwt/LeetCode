package main.java;

public class Solution_2167 {
    public int minimumTime(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length, res = n, time = 0;
        for (int i = 0; i < n; i++) {
            time = ch[i] == '0' ? time : Math.min(time + 2, i + 1);
            res = Math.min(res, time + n - 1 - i);
        }
        return res;
    }
}
