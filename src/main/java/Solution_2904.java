package main.java;

public class Solution_2904 {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length(), l = 0, cnt = 0;
        int start = 0, end = n;
        for (int r = 0; r < n; r++) {
            cnt += s.charAt(r) - '0';
            while (cnt > k || (l < r && s.charAt(l) == '0')) cnt -= s.charAt(l++) - '0';
            if (cnt == k)
                if (r - l < end - start || ((r - l == end - start) && s.substring(l, r + 1).compareTo(s.substring(start, end + 1)) < 0)) {
                    start = l;
                    end = r;
                }
        }
        return start == 0 && end == n ? "" : s.substring(start, end + 1);
    }
}
