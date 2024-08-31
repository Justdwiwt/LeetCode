package main.java;

public class Solution_2309 {
    public String greatestLetter(String s) {
        int[] flag = new int[58];
        for (char i : s.toCharArray()) flag[i - 'A'] = 1;
        for (int i = 25; i >= 0; i--)
            if (flag[i] + flag[i + 32] > 1) return (char) ('A' + i) + "";
        return "";
    }
}
