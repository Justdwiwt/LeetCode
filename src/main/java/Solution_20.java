package main.java;

public class Solution_20 {
    public boolean isValid(String s) {
        int length = s.length() / 2;
        for (int i = 0; i < length; i++)
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        return s.isEmpty();
    }
}
