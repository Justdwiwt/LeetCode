package main.java;

public class Solution_1974 {
    public int minTimeToType(String word) {
        int cur = 0, res = 0;
        for (int i = 0; i < word.length(); i++) {
            int currentChar = word.charAt(i) - 'a', diff = Math.abs(cur - currentChar);
            res += Math.min(27 - diff, diff + 1);
            cur = currentChar;
        }
        return res;
    }
}
