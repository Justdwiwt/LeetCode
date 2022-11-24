package main.java;

public class Solution_1541 {
    public int minInsertions(String s) {
        int balance = 0, res = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == '(') balance++;
            else if (s.charAt(i) == ')') {
                if (i + 1 == s.length() || s.charAt(i + 1) != ')') res++;
                else i++;
                if (balance == 0) res++;
                else balance--;
            }
        return res + (balance << 1);
    }
}
