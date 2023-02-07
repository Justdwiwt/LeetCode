package main.java;

public class Solution_1221 {
    public int balancedStringSplit(String s) {
        int cntL = 0, cntR = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') cntR++;
            else cntL++;
            if (cntL == cntR) res++;
        }
        return res;
    }
}
