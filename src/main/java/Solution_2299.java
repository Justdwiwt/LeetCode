package main.java;

public class Solution_2299 {
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) return false;
        boolean[] v = new boolean[127];
        "!@#$%^&*()-+".chars().forEach(i -> v[i] = true);
        int res = 0;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (c >= '0' && c <= '9') res |= 1 << 2;
            if (c >= 'a' && c <= 'z') res |= 1;
            if (c >= 'A' && c <= 'Z') res |= 1 << 1;
            if (v[c]) res |= 1 << 3;
            if (i > 0 && password.charAt(i - 1) == c) return false;
        }
        return res == ((1 << 4) - 1);
    }
}
