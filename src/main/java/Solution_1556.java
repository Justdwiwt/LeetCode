package main.java;

public class Solution_1556 {
    public String thousandSeparator(int n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        for (int i = sb.length() - 3; i > 0; i -= 3)
            sb.insert(i, '.');
        return sb.toString();
    }
}
