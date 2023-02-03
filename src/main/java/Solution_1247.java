package main.java;

public class Solution_1247 {
    public int minimumSwap(String s1, String s2) {
        int p = 0, q = 0;
        for (int i = 0; i < s1.length(); i++)
            if (s1.charAt(i) != s2.charAt(i))
                if (s1.charAt(i) == 'x') p++;
                else q++;
        if ((p + q) % 2 != 0) return -1;
        return p / 2 + q / 2 + (p % 2 + q % 2);
    }
}
