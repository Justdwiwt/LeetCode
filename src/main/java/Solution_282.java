package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_282 {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) return res;
        help(num, target, 0, 0, 0, "", res);
        return res;
    }

    private void help(String num, int target, long curRes, long diff, int start, String curExp, List<String> expressions) {
        if (start == num.length() && (long) target == curRes) expressions.add(curExp);

        for (int i = start; i < num.length(); i++) {
            String cur = num.substring(start, i + 1);
            if (cur.length() > 1 && cur.charAt(0) == '0') break;

            if (curExp.length() > 0) {
                help(num, target, curRes + Long.parseLong(cur), Long.parseLong(cur), i + 1, curExp + "+" + cur, expressions);
                help(num, target, curRes - Long.parseLong(cur), -Long.parseLong(cur), i + 1, curExp + "-" + cur, expressions);
                help(num, target, (curRes - diff) + diff * Long.parseLong(cur), diff * Long.parseLong(cur),
                        i + 1, curExp + "*" + cur, expressions);
            } else help(num, target, Long.parseLong(cur), Long.parseLong(cur), i + 1, cur, expressions);
        }
    }
}
