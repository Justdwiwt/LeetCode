package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_1415 {
    static final char[] keys = {'a', 'b', 'c'};

    public String getHappyString(int n, int k) {
        List<String> list = new ArrayList<>();
        char[] chars = new char[n];
        dfs(list, chars, 0);
        return list.size() < k ? "" : list.get(k - 1);
    }


    public static void dfs(List<String> list, char[] chars, int begin) {
        if (begin == chars.length) {
            list.add(new String(chars));
            return;
        }

        for (char key : keys) {
            if (begin != 0 && chars[begin - 1] == key) continue;
            chars[begin] = key;
            dfs(list, chars, begin + 1);
            chars[begin] = '\u0000';
        }
    }
}
