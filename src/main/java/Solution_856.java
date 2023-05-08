package main.java;

public class Solution_856 {
    int idx = 0;

    public int scoreOfParentheses(String s) {
        int res = 0;
        while (idx < s.length() && s.charAt(idx) == '(') {
            idx++;
            res += s.charAt(idx) == ')' ? 1 : scoreOfParentheses(s) * 2;
            idx++;
        }
        return res;
    }
}
