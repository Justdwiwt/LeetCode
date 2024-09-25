package main.java;

public class Solution_2337 {
    public boolean canChange(String start, String target) {
        int l = 0, r = 0, n = start.length();
        char[] cs = start.toCharArray(), ct = target.toCharArray();
        for (int i = 0; i < n; i++) {
            if (cs[i] == 'L') {
                if (r > 0) return false;
                l++;
            } else if (cs[i] == 'R') r++;
            if (ct[i] == 'L') {
                if (r > 0) return false;
                l--;
            } else if (ct[i] == 'R') r--;
            if (r < 0 || l > 0) return false;
        }
        return l == 0 && r == 0;
    }
}
