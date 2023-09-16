package main.java;

public class Solution_402 {
    public String removeKdigits(String num, int k) {
        char[] str = num.toCharArray();
        int n = str.length, h = 0, t = -1, rm = 0;
        char[] dq = new char[n];
        for (char c : str) {
            while (h <= t && rm < k && c < dq[t]) {
                t--;
                rm++;
            }
            dq[++t] = c;
        }
        String res = String.valueOf(dq).substring(h, h + n - k).replaceAll("^0+", "");
        return res.equals("") ? "0" : res;
    }
}
