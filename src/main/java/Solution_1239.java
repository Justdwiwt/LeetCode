package main.java;

import java.util.List;

public class Solution_1239 {
    int max = 0;

    public int maxLength(List<String> arr) {
        dfs(arr, new StringBuilder(), 0, 0);
        return max;
    }

    private void dfs(List<String> arr, StringBuilder bd, int map, int cur) {
        if (cur == arr.size()) {
            max = Math.max(max, bd.length());
            return;
        }
        String str = arr.get(cur);
        int tmp = map;
        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if ((tmp & (1 << idx)) > 0) {
                flag = false;
                break;
            }
            tmp |= (1 << idx);
        }
        if (flag) {
            bd.append(str);
            dfs(arr, bd, tmp, cur + 1);
            bd.setLength(bd.length() - str.length());
        }
        dfs(arr, bd, map, cur + 1);
    }
}
