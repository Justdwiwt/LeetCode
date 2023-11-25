package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_306 {
    public boolean isAdditiveNumber(String num) {
        return num != null && num.length() >= 3 && backtrack(0, num, new ArrayList<>());
    }

    private boolean backtrack(int start, String num, List<String> tmp) {
        if (start == num.length() && tmp.size() > 2) return true;
        for (int i = start; i < num.length(); i++) {
            String s = num.substring(start, i + 1);
            if ((s.length() > 1 && s.charAt(0) == '0')) return false;
            if (s.length() > num.length() / 2) return false;
            int size = tmp.size();
            if (size < 2 || s.equals(addStrNum(tmp.get(size - 1), tmp.get(size - 2)))) {
                tmp.add(s);
                if (backtrack(i + 1, num, tmp)) return true;
                tmp.remove(tmp.size() - 1);
            }
        }
        return false;
    }

    private static String addStrNum(String a, String b) {
        StringBuilder sum = new StringBuilder();
        int c = 0;
        for (int ai = a.length() - 1, bi = b.length() - 1; ai >= 0 || bi >= 0; ) {
            int s = 0;
            if (ai >= 0) s += a.charAt(ai--) - '0';
            if (bi >= 0) s += b.charAt(bi--) - '0';
            sum.append((s + c) % 10);
            c = (s + c) >= 10 ? 1 : 0;
        }
        if (c > 0) sum.append(1);
        return sum.reverse().toString();
    }
}
