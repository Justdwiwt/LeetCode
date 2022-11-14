package main.java;

import java.util.LinkedList;
import java.util.stream.IntStream;

public class Solution_1585 {
    public boolean isTransformable(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] char1 = s.toCharArray();
        char[] char2 = t.toCharArray();
        LinkedList<Integer>[] pos = new LinkedList[10];
        for (int i = 0; i < 10; i++) pos[i] = new LinkedList<>();
        int n = s.length();
        IntStream.range(0, n).forEach(i -> pos[char1[i] - '0'].add(i));

        for (int i = n - 1; i >= 0; i--) {
            int cur = char2[i] - '0';
            if (pos[cur].isEmpty()) return false;
            int tmp = pos[cur].getLast();
            for (int j = cur + 1; j < 10; j++)
                if (!pos[j].isEmpty() && pos[j].getLast() >= tmp)
                    return false;
            pos[cur].removeLast();
        }
        return true;
    }
}
