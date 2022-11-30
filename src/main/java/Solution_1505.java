package main.java;

public class Solution_1505 {
    public String minInteger(String num, int k) {
        if (k == 0) return num;
        for (char c = '0'; c <= '9'; c++) {
            int i = num.indexOf(c);
            if (i >= 0)
                if (i <= k)
                    return c + minInteger(num.substring(0, i) + num.substring(i + 1), k - i);
        }
        return num;
    }
}
