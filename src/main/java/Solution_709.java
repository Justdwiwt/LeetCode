package main.java;

public class Solution_709 {
    public String toLowerCase(String str) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 65 && c <= 90) c += 32;
            res.append(c);
        }
        return res.toString();
    }
}
