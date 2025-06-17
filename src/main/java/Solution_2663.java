package main.java;

public class Solution_2663 {
    public String smallestBeautifulString(String s, int k) {
        char[] ch = s.toCharArray();
        for (int i = ch.length - 1; i >= 0; i--)
            for (int j = ch[i] + 1; j < k + 'a'; j++) {
                if (i > 0 && j == ch[i - 1] || i > 1 && j == ch[i - 2]) continue;
                ch[i] = (char) j;
                for (int p = i + 1; p < ch.length; p++)
                    for (int w = 'a'; w < k + 'a'; w++) {
                        if (p > 0 && w == ch[p - 1] || p > 1 && w == ch[p - 2]) continue;
                        ch[p] = (char) w;
                        break;
                    }
                return new String(ch);
            }
        return "";
    }
}
