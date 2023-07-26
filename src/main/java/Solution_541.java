package main.java;

public class Solution_541 {
    public String reverseStr(String s, int k) {
        StringBuilder res = new StringBuilder();
        int idx = 0;
        int n = s.length();
        while (idx < n) {
            int end = Math.min(idx + k, n);
            StringBuilder temp = new StringBuilder(s.substring(idx, end));
            res.append((idx / k) % 2 == 0 ? temp.reverse() : temp);
            idx = end;
        }
        return res.toString();
    }
}
