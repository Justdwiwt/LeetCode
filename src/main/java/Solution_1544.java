package main.java;

public class Solution_1544 {
    public String makeGood(String s) {
        int idx = 1;
        char[] ch = s.toCharArray();
        for (int i = 1; i < ch.length; i++)
            if (idx == 0 || Math.abs(ch[i] - ch[idx - 1]) != 32) ch[idx++] = ch[i];
            else idx--;
        return new String(ch).substring(0, idx);
    }
}
