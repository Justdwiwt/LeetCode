package main.java;

public class Solution_2938 {
    public long minimumSteps(String s) {
        long res = 0;
        int len = s.length(), x = 0;
        for (int i = len - 1; i >= 0; i--)
            if (s.charAt(i) == '1') res += x;
            else x++;
        return res;
    }
}
