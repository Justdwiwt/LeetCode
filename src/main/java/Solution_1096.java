package main.java;

import java.util.*;

public class Solution_1096 {
    private int i = 0;

    public List<String> braceExpansionII(String expression) {
        List<String> res = new ArrayList<>(dfs(expression.toCharArray()));
        Collections.sort(res);
        return res;
    }

    private Set<String> dfs(char[] s) {
        Set<String> st1 = new HashSet<>();
        if (s[i] == '{') while (s[i] != '}') {
            i += 1;
            st1.addAll(dfs(s));
        }
        else st1.add(String.valueOf(s[i]));
        i += 1;
        if (i == s.length || s[i] == ',' || s[i] == '}') return st1;
        Set<String> res = new HashSet<>();
        Set<String> st2 = dfs(s);
        st1.forEach(a -> st2.stream().map(b -> a + b).forEach(res::add));
        return res;
    }
}
