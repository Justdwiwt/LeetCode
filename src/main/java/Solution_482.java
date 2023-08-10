package main.java;

public class Solution_482 {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder(s.replaceAll("-", "").toUpperCase());
        for (int i = sb.length() - k; i > 0; i -= k) sb.insert(i, '-');
        return sb.toString();
    }
}
