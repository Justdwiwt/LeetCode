package main.java;

public class Solution_1750 {
    public int minimumLength(String s) {
        char[] ch = s.toCharArray();
        int l = 0, r = ch.length - 1;
        while (l < r && ch[l] == ch[r]) {
            while (l + 1 <= r && ch[l + 1] == ch[l]) l++;
            while (r - 1 >= l && ch[r - 1] == ch[r]) r--;
            l++;
            r--;
        }
        int res = r - l + 1;
        return Math.max(res, 0);
    }
}
