package main.java;

public class Solution_678 {
    int[][] visit;

    public boolean checkValidString(String s) {
        visit = new int[s.length()][s.length()];
        return check(s, 0, 0);
    }

    private boolean check(String s, int pos, int cur) {
        if (pos == s.length()) return cur == 0;
        if (visit[pos][cur] != 0) return visit[pos][cur] == 1;
        if (cur == 0 && s.charAt(pos) == ')') return false;
        boolean res = false;
        if (s.charAt(pos) == '*') {
            res |= check(s, pos + 1, cur + 1);
            res |= check(s, pos + 1, cur);
            if (cur > 0) res |= check(s, pos + 1, cur - 1);
        } else res |= s.charAt(pos) == ')' ? check(s, pos + 1, cur - 1) : check(s, pos + 1, cur + 1);
        visit[pos][cur] = res ? 1 : 2;
        return res;
    }
}
