package main.java;

public class Solution_696 {
    public int countBinarySubstrings(String s) {
        char[] ch = s.toCharArray();
        int cnt = 1, pre = 0;
        int res = 0;
        for (int i = 1; i < ch.length; i++)
            if (ch[i - 1] == ch[i]) cnt++;
            else {
                res += Math.min(pre, cnt);
                pre = cnt;
                cnt = 1;
            }
        res += Math.min(pre, cnt);
        return res;
    }
}
