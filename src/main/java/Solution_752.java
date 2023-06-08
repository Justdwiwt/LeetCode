package main.java;

import java.util.*;
import java.util.stream.IntStream;

public class Solution_752 {
    public int openLock(String[] deadends, String target) {
        Set<String> strings = new HashSet<>(Arrays.asList(deadends));
        if (strings.contains("0000")) return -1;
        int count = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        Set<String> used = new HashSet<>();
        used.add("0000");
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                String cur = queue.poll();
                assert cur != null;
                if (cur.equals(target)) return count;
                used.add(cur);
                IntStream.range(0, 4).forEach(j -> {
                    StringBuilder curSb = new StringBuilder(cur);
                    curSb.setCharAt(j, cur.charAt(j) == '0' ? '9' : (char) (cur.charAt(j) - 1));
                    if (!used.contains(curSb.toString()) && !strings.contains(curSb.toString())) {
                        used.add(curSb.toString());
                        queue.add(curSb.toString());
                    }
                    curSb.setCharAt(j, cur.charAt(j) == '9' ? '0' : (char) (cur.charAt(j) + 1));
                    if (!used.contains(curSb.toString()) && !strings.contains(curSb.toString())) {
                        used.add(curSb.toString());
                        queue.add(curSb.toString());
                    }
                });
            }
            count++;
        }
        return -1;
    }
}
