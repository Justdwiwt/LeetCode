package main.java;

public class Solution_639 {
    final int M = (int) 1e9 + 7;

    public int numDecodings(String s) {
        char[] ch = s.toCharArray();
        if (ch[0] == '0') return 0;
        long[] res = new long[ch.length + 1];
        res[0] = 1;
        res[1] = ch[0] == '*' ? 9 : 1;
        for (int i = 1; i < ch.length; i++)
            if (ch[i - 1] == '*' && ch[i] == '*')
                res[i + 1] = (res[i] * 9 + res[i - 1] * 15) % M;
            else if (ch[i - 1] == '*') {
                if (ch[i] != '0') res[i + 1] = res[i];
                res[i + 1] = ch[i] > '6' ? (res[i + 1] + res[i - 1]) % M : (res[i + 1] + res[i - 1] * 2) % M;
            } else if (ch[i] == '*') {
                res[i + 1] = res[i] * 9;
                if (ch[i - 1] == '1') res[i + 1] = (res[i + 1] + res[i - 1] * 9) % M;
                else if (ch[i - 1] == '2') res[i + 1] = (res[i + 1] + res[i - 1] * 6) % M;
                else res[i + 1] %= M;
            } else {
                if (ch[i - 1] == '0' && ch[i] == '0') return 0;
                if (ch[i] != '0') res[i + 1] = res[i];
                if (ch[i - 1] != '0') {
                    int pre = (ch[i - 1] - '0') * 10 + ch[i] - '0';
                    if (pre < 27) res[i + 1] = (res[i + 1] + res[i - 1]) % M;
                }
            }
        return (int) res[ch.length];
    }
}
