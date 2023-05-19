package main.java;

import java.util.stream.IntStream;

public class Solution_824 {
    public String toGoatLatin(String sentence) {
        String[] s = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        StringBuilder end = new StringBuilder();
        IntStream.range(0, s.length).forEach(i -> {
            String begin = s[i].substring(0, 1);
            if ("a".equalsIgnoreCase(begin) || "e".equalsIgnoreCase(begin) || "i".equalsIgnoreCase(begin) || "o".equalsIgnoreCase(begin) || "u".equalsIgnoreCase(begin))
                res.append(s[i]).append("ma");
            else res.append(s[i].substring(1)).append(begin).append("ma");
            end.append("a");
            res.append(end).append(" ");
        });
        return res.substring(0, res.length() - 1);
    }
}
