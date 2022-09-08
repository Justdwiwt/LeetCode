package main.java;

public class Solution_1880 {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return getNum(firstWord) + getNum(secondWord) == getNum(targetWord);
    }

    private int getNum(String s) {
        int res = 0;
        int n = s.length();
        for (int i = 0; i < n; i++)
            res = res * 10 + (s.charAt(i) - 'a');
        return res;
    }
}
