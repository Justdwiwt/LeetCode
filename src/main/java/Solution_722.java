package main.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_722 {
    public List<String> removeComments(String[] source) {
        StringBuilder sb = new StringBuilder(String.join("\n", source)).append('\n');
        for (int i = 0, j; i < sb.length(); i = j) {
            if ((j = sb.indexOf("/", i)) == -1) break;
            char c = sb.charAt(j + 1);
            if (c == '/') sb.delete(j, sb.indexOf("\n", j + 2));
            else if (c == '*') sb.delete(j, sb.indexOf("*/", j + 2) + 2);
            else j += 2;
        }
        return Arrays.stream(sb.toString().split("\n")).filter(s -> s.length() > 0).collect(Collectors.toList());
    }
}
