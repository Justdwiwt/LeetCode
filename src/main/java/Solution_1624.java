package main.java;

public class Solution_1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        int res = -1;
        for (int i = 0; i < s.length(); i++)
            res = Math.max(res, s.lastIndexOf(s.charAt(i)) - i - 1);
        return res;
    }
}
