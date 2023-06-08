package main.java;

import java.util.*;
import java.util.stream.IntStream;

public class Solution_756 {
    Map<String, List<String>> m = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        allowed.forEach(s -> {
            String substring = s.substring(0, 2);
            List<String> orDefault = m.getOrDefault(substring, new ArrayList<>());
            orDefault.add(Character.toString(s.charAt(2)));
            m.put(substring, orDefault);
        });
        int len = bottom.length(), l = 0;
        return IntStream.range(0, len)
                .filter(i -> i - l + 1 == 2)
                .mapToObj(i -> bottom.substring(l, i + 1))
                .map(substring -> m.get(substring))
                .noneMatch(Objects::isNull) && dfs(bottom, bottom.length() - 1, "", 0, 2);
    }

    private boolean dfs(String bottom, int num, String s, int l, int r) {
        int len = bottom.length();
        if (r > len) return false;
        if (num == 1) {
            List<String> list = m.get(bottom);
            return list != null;
        }
        String substring = bottom.substring(l, r);
        List<String> list = m.get(substring);
        if (list == null) return false;
        for (String s1 : list) {
            boolean flag = r == len ? dfs(s + s1, num - 1, "", 0, 2) : dfs(bottom, num, s + s1, l + 1, r + 1);
            if (flag) return true;
        }
        return false;
    }
}
