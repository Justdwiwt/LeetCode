package main.java;

public class Solution_1021 {
    public String removeOuterParentheses(String S) {
        int left = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(' && left++ > 0) res.append('(');
            if (S.charAt(i) == ')' && --left > 0) res.append(')');
        }
        return res.toString();
    }
}
