package main.java;

public class Solution_806 {
    public int[] numberOfLines(int[] widths, String s) {
        int[] res = new int[2];
        res[0] = 1;
        for (char arr : s.toCharArray()) {
            res[1] += widths[arr - 'a'];
            if (res[1] > 100) {
                res[1] = widths[arr - 'a'];
                res[0]++;
            }
        }
        return res;
    }
}
