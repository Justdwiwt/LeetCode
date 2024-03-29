package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_761 {
    public String makeLargestSpecial(String s) {
        int count = 0, pre = 0, n = s.length();
        if (n == 0) return "";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '1') count++;
            else {
                count--;
                if (count == 0) {
                    list.add("1" + makeLargestSpecial(s.substring(pre + 1, i)) + "0");
                    pre = i + 1;
                }
            }
        }
        Collections.sort(list);
        StringBuilder res = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) res.append(list.get(i));
        return res.toString();
    }
}
