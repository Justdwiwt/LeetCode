package main.java;

import java.util.stream.IntStream;

public class Solution_2323 {
    public String decodeMessage(String key, String message) {
        char[] map = new char[26];
        char curChar = 'a';
        for (char i : key.toCharArray())
            if (i != ' ' && map[i - 'a'] == 0) map[i - 'a'] = curChar++;
        char[] res = message.toCharArray();
        IntStream.range(0, res.length).filter(i -> res[i] != ' ').forEach(i -> res[i] = map[res[i] - 'a']);
        return new String(res);
    }
}
