package main.java;

public class Solution_1003 {
    public boolean isValid(String S) {
        while (S.contains("abc")) S = S.replace("abc", "");
        return "".equals(S);
    }
}
