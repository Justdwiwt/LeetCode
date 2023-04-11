package main.java;

import java.util.Arrays;
import java.util.Objects;

public class Solution_937 {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (o1, o2) -> {
            char c1 = o1.charAt(o1.length() - 1);
            char c2 = o2.charAt(o2.length() - 1);
            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                String tmp1 = o1.substring(o1.indexOf(' '));
                String tmp2 = o2.substring(o2.indexOf(' '));
                if (Objects.equals(tmp1, tmp2)) return o1.compareTo(o2);
                return tmp1.compareTo(tmp2);
            } else return Character.isDigit(c1) && Character.isDigit(c2) ? 0 : Character.isDigit(c1) ? 1 : -1;
        });
        return logs;
    }
}
