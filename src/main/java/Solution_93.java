package main.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_93 {
    private List<String> res;

    private LinkedList<String> path;

    public List<String> restoreIpAddresses(String s) {
        this.res = new ArrayList<>();
        this.path = new LinkedList<>();

        backTracking(s, 0);

        return res;
    }

    private void backTracking(String s, int start) {
        if (path.size() == 4 && start >= s.length()) {
            res.add(String.join(".", path));
            return;
        }

        IntStream.range(start, s.length()).forEach(i -> {
            String cur = s.substring(start, i + 1);
            if (s.charAt(start) == '0' && cur.length() > 1) return;

            if (cur.length() > 3 || Integer.parseInt(cur) > 255) return;
            path.add(cur);
            backTracking(s, i + 1);
            path.removeLast();
        });
    }
}
