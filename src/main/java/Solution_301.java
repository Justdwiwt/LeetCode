package main.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_301 {
    int maxLength = 0;
    List<String> ans = new ArrayList<>();
    Set<String> set = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        formString(0, s, "");
        set.stream().filter(str -> str.length() == maxLength).forEach(str -> ans.add(str));
        return ans;
    }

    public boolean isGood(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            else if (s.charAt(i) == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }

    public void formString(int i, String s, String str) {
        if (i == s.length()) {
            if (isGood(str)) {
                set.add(str);
                maxLength = Math.max(maxLength, str.length());
            }
            return;
        }
        if (s.charAt(i) == '(' || s.charAt(i) == ')') formString(i + 1, s, str);
        formString(i + 1, s, str + (char) s.charAt(i));
    }
}
