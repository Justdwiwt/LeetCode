package main.java;

public class Solution_1446 {
    public static int maxPower(String s) {
        char[] ch = s.toCharArray();
        int cnt = 1, max = 0;
        for (int i = 1; i < ch.length; i++) {
            cnt += ch[i] == ch[i - 1] ? 1 : -cnt + 1;
            max = Math.max(max, cnt);
        }
        return Math.max(max, cnt);
    }
}
