package main.java;

public class Solution_831 {
    private final String[] diff = {"", "+*-", "+**-", "+***-"};

    public String maskPII(String s) {
        int idx = s.indexOf("@");
        if (idx > 0) {
            s = s.toLowerCase();
            return (s.charAt(0) + "*****" + s.substring(idx - 1)).toLowerCase();
        }
        s = s.replaceAll("[^0-9]", "");
        return diff[s.length() - 10] + "***-***-" + s.substring(s.length() - 4);
    }
}
