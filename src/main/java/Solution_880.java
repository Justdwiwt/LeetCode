package main.java;

public class Solution_880 {
    public String decodeAtIndex(String s, int k) {
        long cnt = 0;
        int i = 0;
        for (; i < s.length(); i++) cnt = Character.isDigit(s.charAt(i)) ? cnt * (s.charAt(i) - '0') : cnt + 1;
        for (i--; i >= 0; i--)
            if (Character.isDigit(s.charAt(i))) {
                cnt /= (s.charAt(i) - '0');
                k %= cnt;
            } else {
                if (k % cnt == 0) return s.charAt(i) + "";
                cnt--;
            }
        return "";
    }
}
