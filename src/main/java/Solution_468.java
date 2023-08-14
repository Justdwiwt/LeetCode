package main.java;

public class Solution_468 {
    public String validIPAddress(String queryIP) {
        return isIPv4(queryIP) ? "IPv4" : isIPv6(queryIP) ? "IPv6" : "Neither";
    }

    public boolean isIPv4(String s) {
        String[] t = s.split("\\.", -1);
        if (t.length != 4) return false;
        for (int i = 0; i < 4; i++) {
            if (t[i].length() == 0 || t[i].length() > 3 || t[i].length() > 1 && t[i].charAt(0) == '0') return false;
            int sum = 0;
            for (char c : t[i].toCharArray()) {
                if (!Character.isDigit(c)) return false;
                sum = sum * 10 + c - '0';
            }
            if (sum > 255) return false;
        }
        return true;
    }

    public boolean isIPv6(String s) {
        s = s.toLowerCase();
        String[] t = s.split(":", -1);
        if (t.length != 8) return false;
        for (int i = 0; i < 8; i++) {
            if (t[i].length() == 0 || t[i].length() > 4) return false;
            for (char c : t[i].toCharArray())
                if (!(c >= '0' && c <= '9') && !(c >= 'a' && c <= 'f')) return false;
        }
        return true;
    }
}
