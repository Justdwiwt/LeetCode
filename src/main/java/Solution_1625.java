package main.java;

import java.util.HashSet;
import java.util.Set;

public class Solution_1625 {
    Set<String> st;

    public String findLexSmallestString(String s, int a, int b) {
        st = new HashSet<>();
        f(s, a, b);
        return st.stream().sorted().findFirst().get();
    }

    private void f(String s, int a, int b) {
        if (st.contains(s)) return;
        else st.add(s);
        f(g(s, a), a, b);
        f(h(s, b), a, b);
    }

    private String g(String s, int a) {
        char[] ch = s.toCharArray();
        for (int i = 1; i < s.length(); i += 2)
            ch[i] = (char) (((s.charAt(i) - '0' + a) % 10) + '0');
        return String.valueOf(ch);
    }

    private String h(String s, int b) {
        return s.substring(s.length() - b) + s.substring(0, s.length() - b);
    }
}