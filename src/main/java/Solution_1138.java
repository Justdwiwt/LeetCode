package main.java;

public class Solution_1138 {
    public String alphabetBoardPath(String target) {
        StringBuilder res = new StringBuilder();
        int l = 0, r = 0;
        for (int j = 0; j < target.length(); j++) {
            char c = target.charAt(j);
            if (j > 0 && c == target.charAt(j - 1)) {
                res.append("!");
                continue;
            }
            int n = (c - 'a') / 5, m = (c - 'a') % 5;

            for (int i = 0; i < Math.abs(n - l) + (c == 'z' ? -1 : 0); i++)
                res.append(n - l > 0 ? "D" : "U");
            for (int i = 0; i < Math.abs(m - r); i++)
                res.append(m - r > 0 ? "R" : "L");
            res.append(c == 'z' ? "D!" : "!");
            l = n;
            r = m;
        }
        return res.toString();
    }
}
